package ru.innopolis.lesson14;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Класс, предоставляющий переменные окружения среды
 */
@Stateless
public class Environment {

    /**
     * Возвращает полный список переменных окружения
     *
     * @return Возвращает ключ-значение записанные в ArrayList
     */
    public List<Map.Entry<String, String>> getEnvironment() {
        final Map<String, String> environments = System.getenv();
        return new ArrayList<>(environments.entrySet());
    }

    /**
     * Возвращает значение по имени переменной
     *
     * @param name имя переменной среды
     * @return значение по имени переменной
     */
    public Optional<String> getEnvironmentValue(String name)  {
        final Map<String, String> environments = System.getenv();
        return Optional.ofNullable(environments.get(name));
    }
}
