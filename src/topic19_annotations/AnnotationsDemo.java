package topic19_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * ============================================================================
 * TOPIC 19: JAVA ANNOTATIONS (METADATA & COMPILER INSTRUCTIONS)
 * ============================================================================
 * 
 * 📌 ANNOTATION KYA HAI?
 * - Annotation (`@`) Java code ke baare mein "Metadata" (Data about Data) hota hai.
 * - Ye code ke logic ko change nahi karta, balki Compiler ya Runtime Frameworks 
 *   (jaise Spring Boot, Hibernate) ko special instructions deta hai.
 * 
 * 📌 COMMON BUILT-IN ANNOTATIONS:
 * 1. `@Override`               -> Compiler check karta hai ki method parent se override ho raha hai ya nahi.
 * 2. `@Deprecated`             -> Warn karta hai ki ye method purana ho chuka hai, naya method use karo.
 * 3. `@SuppressWarnings("...")`-> Compiler ki warnings (jaise unused variable) ko chup/suppress karta hai.
 * 4. `@FunctionalInterface`    -> Ensure karta hai ki interface me SIRF 1 abstract method ho.
 */

// ----------------------------------------------------------------------------
// 1. CUSTOM ANNOTATION CREATION
// ----------------------------------------------------------------------------
// @Target: Ye annotation kahan lag sakti hai? (METHOD, TYPE/Class, FIELD)
// @Retention: Ye kab tak zinda rahegi? (RUNTIME tak taaki Reflection se read ho sake)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DeveloperInfo {
    String author() default "Admin";
    int version() default 1;
    String description();
}

// ----------------------------------------------------------------------------
// 2. CLASS USING ANNOTATIONS
// ----------------------------------------------------------------------------
class SoftwareService {

    // Built-in @Deprecated Annotation
    @Deprecated
    public void oldSlowLogin() {
        System.out.println("Old Login: Using legacy authentication protocol.");
    }

    public void newFastLogin() {
        System.out.println("New Login: Using fast OAuth2 & JWT tokens! 🚀");
    }

    // Custom Annotation applied to method
    @DeveloperInfo(author = "Aman Kumar", version = 2, description = "Secure payment processing gateway")
    public void processTransaction() {
        System.out.println("Transaction: Rs. 5000 transferred securely.");
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class AnnotationsDemo {

    @SuppressWarnings("deprecation") // Suppress warning for using deprecated method
    public static void main(String[] args) throws Exception {
        System.out.println("==================================================");
        System.out.println("       TOPIC 19: JAVA ANNOTATIONS COMPLETE DEMO   ");
        System.out.println("==================================================\n");

        SoftwareService service = new SoftwareService();

        // 1. Calling Deprecated & New methods
        System.out.println("--- 1. Testing Built-in Annotations ---");
        service.oldSlowLogin();
        service.newFastLogin();
        service.processTransaction();
        System.out.println();

        // 2. Reading Custom Annotation at Runtime using Reflection
        System.out.println("--- 2. Reading Custom Annotation at Runtime (Reflection) ---");
        Method method = SoftwareService.class.getMethod("processTransaction");

        if (method.isAnnotationPresent(DeveloperInfo.class)) {
            DeveloperInfo info = method.getAnnotation(DeveloperInfo.class);
            System.out.println("🔍 Found @DeveloperInfo Metadata on method: " + method.getName());
            System.out.println("   Author      : " + info.author());
            System.out.println("   Version     : v" + info.version());
            System.out.println("   Description : " + info.description());
        }

        System.out.println("\n==================================================");
        System.out.println("         ANNOTATIONS DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }
}
