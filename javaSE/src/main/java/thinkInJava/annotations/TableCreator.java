package thinkInJava.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEX on 10.07.2016.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        args=new String[] {"org.mycompany.annotations.Member"};
        for(String className: args) {
            Class<?> cl=Class.forName(className);
            DBTable dbTable=cl.getAnnotation(DBTable.class);
            if(dbTable == null) {
                System.out.println("No dbtable annotation in class " + className);
                continue;
            }
            String tableName= dbTable.name();
            if(tableName.isEmpty()) {
                tableName=cl.getName().toUpperCase();
            }
            List<String> columnDefs=new ArrayList<>();
            for(Field f: cl.getDeclaredFields()) {
               String columnName=null;
                Annotation[] anns=f.getDeclaredAnnotations();
                if(anns.length <1) {
                    continue;
                }
                if(anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if(sInt.name().isEmpty()) {
                        columnName = f.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " " +
                    "INT" + getConstraints(sInt.constraints()));

                }
                if(anns[0] instanceof SQLString) {
                    SQLString sqlString= (SQLString) anns[0];
                    if(sqlString.name().isEmpty()) {
                        columnName = f.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name().toUpperCase();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" +
                    getConstraints(sqlString.constraints()));
                }
            }
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " +  tableName + "(" );
            for(String  columnDef: columnDefs) {
                createCommand.append("\n     " +columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " +
                    className + " is :\n" + tableCreate);
        }


    }
    private static String getConstraints(Constraints constraints) {
          StringBuilder sb=new StringBuilder();
        if(constraints.primaryKey()) {
            sb.append(" PRIMARY KEY");
        }
        if(!constraints.nullable()) {
            sb.append(" NOT NULL");
        }
        if(constraints.unique()) {
            sb.append(" UNIQUE");
        }
        return sb.toString();


    }
}