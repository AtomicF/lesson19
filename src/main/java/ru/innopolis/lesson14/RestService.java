package ru.innopolis.lesson14;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST сервис для предоставления списка переменных среды
 * Запросом http://localhost:8080/lesson14-1.0/environments можно получить список всех переменных среды
 * http://localhost:8080/lesson14-1.0/environments?param=ИМЯ_ПЕРЕМЕННОЙ вывод конкретного значения переменной
 */
public class RestService extends HttpServlet {

    /**
     * Внедрение компонента accessor
     */
    @EJB
    private Environment environment;

    /**
     * Метод обрабатывает запрос, в зависимости от запроса отправляет соответствующий ответ
     *
     * @param req  запрос
     * @param resp ответ
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        final List<Map.Entry<String, String>> env = environment.getEnvironment();

        if (param != null) {
            final Optional<String> value = environment.getEnvironmentValue(param);
            if (value.isPresent()) {
                resp.getWriter().println(value.get());
            } else {
                resp.getWriter().println("Переменная не найдена");
            }
        } else {
            for (Map.Entry<String, String> entry : env) {
                resp.getWriter().println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
