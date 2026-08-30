package topic19_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * ============================================================================
 * TOPIC 19: ANNOTATIONS (PRACTICE QUESTIONS)
 * ============================================================================
 */

// Custom Annotation for Role-Based Access Control
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresRole {
    String role();
}

class AdminService {

    @RequiresRole(role = "ADMIN")
    public void deleteDatabase() {
        System.out.println("⚠️ Database deleted by Authorized Admin!");
    }

    @RequiresRole(role = "USER")
    public void viewProfile() {
        System.out.println("👤 Profile page viewed.");
    }
}

public class AnnotationsPractice {

    public static void main(String[] args) throws Exception {
        System.out.println("==================================================");
        System.out.println("        TOPIC 19: ANNOTATIONS PRACTICE            ");
        System.out.println("==================================================\n");

        AdminService service = new AdminService();

        // Testing Security Interceptor using Reflection
        String currentUserRole = "USER";
        System.out.println("Current User Role: " + currentUserRole + "\n");

        Method[] methods = AdminService.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(RequiresRole.class)) {
                RequiresRole required = m.getAnnotation(RequiresRole.class);
                System.out.print("Trying to execute [" + m.getName() + "] (Requires: " + required.role() + ") -> ");

                if (required.role().equals(currentUserRole)) {
                    System.out.println("Access Granted! ✅");
                    m.invoke(service);
                } else {
                    System.out.println("Access Denied! ❌ (Insufficient Role)");
                }
            }
        }

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
