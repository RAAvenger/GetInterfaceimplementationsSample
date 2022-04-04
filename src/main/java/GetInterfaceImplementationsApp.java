import mypack.TheContrat;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class GetInterfaceImplementationsApp {
    public static void main(String[] args) {
        var implementations = new Reflections(TheContrat.class.getPackageName()).getSubTypesOf(TheContrat.class);
        for (var implementation : implementations) {
            try {
                var newObj = implementation.getDeclaredConstructor().newInstance();
                System.out.println(newObj.getStr());
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

