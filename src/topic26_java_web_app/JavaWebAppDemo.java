package topic26_java_web_app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * ============================================================================
 * TOPIC 26: JAVA WEB APPLICATIONS & WEBPAGES (HTTP SERVER, SERVLETS & HTML)
 * ============================================================================
 * 
 * 📌 JAVA WEB APPLICATION KYA HAI?
 * - Java Web Application ek aisa software program hota hai jo Server par run hota
 *   hai aur Web Browsers (Clients) se HTTP Requests receive karke dynamic HTML Webpages
 *   ya JSON APIs return karta hai.
 * 
 * 📌 ARCHITECTURE & REQUEST-RESPONSE CYCLE:
 *   1. CLIENT (Browser)  -> Sends HTTP Request (GET /dashboard, POST /login)
 *   2. WEB SERVER        -> Accepts connection on Port (e.g. 8080)
 *   3. CONTROLLER/HANDLER-> Executes Java business logic, connects with DB
 *   4. RESPONSE          -> Sends HTTP Status Code (200 OK) + Content-Type (HTML / JSON)
 * 
 * 📌 EVOLUTION OF JAVA WEB DEVELOPMENT:
 * -----------------------------------------------------------------------------
 * Era / Tech              Role & Description
 * -----------------------------------------------------------------------------
 * 1. Servlets & JSP       Original Java Web (Servlets = Java Logic, JSP = HTML View)
 * 2. Spring MVC / Boot    Modern Enterprise Standard (Annotations @Controller, @RestController)
 * 3. RESTful Microservices Backend APIs (Returns JSON for React/Angular/Mobile Apps)
 * -----------------------------------------------------------------------------
 */

// Model Entity for Webpage & API Data
class Course {
    int id;
    String title;
    String instructor;
    double price;

    Course(int id, String title, String instructor, double price) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.price = price;
    }
}

public class JavaWebAppDemo {

    // In-memory data store for the web application
    private static final List<Course> courseCatalog = new ArrayList<>(Arrays.asList(
        new Course(1, "Core & Advanced Java Masterclass", "Vibhor Pundhir", 49.99),
        new Course(2, "Spring Boot Microservices", "Aman Sharma", 59.99),
        new Course(3, "FullStack Java + React", "Pooja Verma", 69.99)
    ));

    public static void main(String[] args) throws Exception {
        System.out.println("==================================================");
        System.out.println("   TOPIC 26: JAVA WEB APPLICATIONS & WEBPAGES     ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // 1. CREATING & CONFIGURING HTTP WEB SERVER
        // --------------------------------------------------------------------
        HttpServer server = startServerOnAvailablePort();
        int port = server.getAddress().getPort();
        System.out.println("--> Step 1: Initializing Java Web Server on port " + port + "...");

        // --------------------------------------------------------------------
        // 2. REGISTERING ROUTES (URL PATH HANDLERS)
        // --------------------------------------------------------------------
        // Route 1: Home Webpage (Serves Dynamic HTML & CSS)
        server.createContext("/", new HomePageHandler());

        // Route 2: REST API (Serves JSON data)
        server.createContext("/api/courses", new CourseApiHandler());

        // Route 3: Form Submission Handler (Processes POST requests)
        server.createContext("/add-course", new AddCourseFormHandler());

        // Multi-threaded server executor pool
        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(5);
        server.setExecutor(executor);
        server.start();

        System.out.println("✔ Java Web Server is running successfully!");
        System.out.println("🌐 Open in your browser: http://localhost:" + port + "/");
        System.out.println("🔗 REST API Endpoint  : http://localhost:" + port + "/api/courses\n");

        // --------------------------------------------------------------------
        // 3. LIVE AUTOMATED CLIENT SIMULATION (HTTP GET & POST REQUESTS)
        // --------------------------------------------------------------------
        System.out.println("--- 2. Automated Client Request Simulation ---");
        HttpClient client = HttpClient.newHttpClient();

        // A. Testing GET / (HTML Webpage)
        System.out.println("--> [GET /] Requesting HTML Webpage...");
        HttpRequest pageRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/"))
            .GET()
            .build();
        HttpResponse<String> pageResponse = client.send(pageRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • HTTP Status: " + pageResponse.statusCode() + " OK");
        System.out.println("  • Content-Type: " + pageResponse.headers().firstValue("Content-Type").orElse("unknown"));
        System.out.println("  • HTML Preview: " + pageResponse.body().substring(0, Math.min(180, pageResponse.body().length())) + "...\n");

        // B. Testing GET /api/courses (JSON API)
        System.out.println("--> [GET /api/courses] Requesting REST API JSON...");
        HttpRequest apiRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/api/courses"))
            .GET()
            .build();
        HttpResponse<String> apiResponse = client.send(apiRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • HTTP Status: " + apiResponse.statusCode() + " OK");
        System.out.println("  • JSON Body  :\n" + apiResponse.body() + "\n");

        // C. Testing POST /add-course (Form Submission)
        System.out.println("--> [POST /add-course] Submitting new course via HTTP POST...");
        String formData = "title=Docker+and+Kubernetes&instructor=Karan+Singh&price=39.99";
        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/add-course"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(formData))
            .build();
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • HTTP Status: " + postResponse.statusCode());
        System.out.println("  • Server Response: " + postResponse.body());

        // Stop server and executor gracefully
        server.stop(0);
        executor.shutdown();
        System.out.println("\n✔ Web Server gracefully stopped for this demo run.");

        System.out.println("\n==================================================");
        System.out.println("        JAVA WEB APP DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }

    private static HttpServer startServerOnAvailablePort() {
        int[] candidatePorts = {8080, 8085, 8090, 9000, 0};
        for (int p : candidatePorts) {
            try {
                return HttpServer.create(new InetSocketAddress(p), 0);
            } catch (IOException ignored) {}
        }
        throw new IllegalStateException("Failed to bind to any HTTP port.");
    }

    // ========================================================================
    // ROUTE HANDLER 1: HTML WEBPAGE GENERATOR
    // ========================================================================
    static class HomePageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Build dynamic HTML webpage with modern embedded CSS styling
            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html>\n")
                .append("<html lang='en'>\n<head>\n")
                .append("<meta charset='UTF-8'>\n")
                .append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n")
                .append("<title>Java Web Application Portal</title>\n")
                .append("<style>\n")
                .append("  body { font-family: 'Segoe UI', Tahoma, sans-serif; background: #f0f4f8; margin: 0; padding: 20px; color: #1e293b; }\n")
                .append("  .container { max-width: 900px; margin: 0 auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.08); }\n")
                .append("  h1 { color: #0284c7; margin-top: 0; }\n")
                .append("  .badge { background: #0284c7; color: white; padding: 4px 10px; border-radius: 20px; font-size: 13px; }\n")
                .append("  table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n")
                .append("  th, td { text-align: left; padding: 12px; border-bottom: 1px solid #e2e8f0; }\n")
                .append("  th { background: #f8fafc; color: #475569; font-weight: 600; }\n")
                .append("  tr:hover { background: #f1f5f9; }\n")
                .append("  .form-box { background: #f8fafc; padding: 20px; border-radius: 8px; margin-top: 25px; border: 1px solid #e2e8f0; }\n")
                .append("  input, button { padding: 10px; border-radius: 6px; border: 1px solid #cbd5e1; margin-right: 10px; }\n")
                .append("  button { background: #0284c7; color: white; border: none; font-weight: bold; cursor: pointer; }\n")
                .append("  button:hover { background: #0369a1; }\n")
                .append("</style>\n</head>\n<body>\n")
                .append("<div class='container'>\n")
                .append("  <h1>☕ Java Web Application Portal <span class='badge'>Live HTTP Server</span></h1>\n")
                .append("  <p>This dynamic webpage is served directly by standard Java backend code.</p>\n")
                .append("  <h3>📚 Available Course Catalog (" + courseCatalog.size() + ")</h3>\n")
                .append("  <table>\n")
                .append("    <thead><tr><th>ID</th><th>Course Title</th><th>Instructor</th><th>Price</th></tr></thead>\n")
                .append("    <tbody>\n");

            // Loop through Java objects and generate HTML rows
            for (Course c : courseCatalog) {
                html.append(String.format("      <tr><td>#%d</td><td><strong>%s</strong></td><td>%s</td><td>$%.2f</td></tr>\n",
                    c.id, c.title, c.instructor, c.price));
            }

            html.append("    </tbody>\n  </table>\n")
                .append("  <div class='form-box'>\n")
                .append("    <h3>➕ Add New Course</h3>\n")
                .append("    <form action='/add-course' method='POST'>\n")
                .append("      <input type='text' name='title' placeholder='Course Title' required>\n")
                .append("      <input type='text' name='instructor' placeholder='Instructor Name' required>\n")
                .append("      <input type='number' step='0.01' name='price' placeholder='Price ($)' required>\n")
                .append("      <button type='submit'>Add Course</button>\n")
                .append("    </form>\n")
                .append("  </div>\n")
                .append("</div>\n</body>\n</html>");

            byte[] responseBytes = html.toString().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }
    }

    // ========================================================================
    // ROUTE HANDLER 2: REST JSON API HANDLER (/api/courses)
    // ========================================================================
    static class CourseApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
                return;
            }

            // Convert Java collection to JSON string format
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < courseCatalog.size(); i++) {
                Course c = courseCatalog.get(i);
                json.append(String.format("  {\"id\": %d, \"title\": \"%s\", \"instructor\": \"%s\", \"price\": %.2f}%s\n",
                    c.id, c.title, c.instructor, c.price, (i < courseCatalog.size() - 1 ? "," : "")));
            }
            json.append("]");

            byte[] jsonBytes = json.toString().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, jsonBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(jsonBytes);
            }
        }
    }

    // ========================================================================
    // ROUTE HANDLER 3: FORM POST HANDLER (/add-course)
    // ========================================================================
    static class AddCourseFormHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            // Read incoming POST request body
            InputStream is = exchange.getRequestBody();
            String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            // Parse URL-encoded form data (key1=value1&key2=value2)
            Map<String, String> params = new HashMap<>();
            for (String pair : body.split("&")) {
                String[] kv = pair.split("=");
                if (kv.length == 2) {
                    params.put(java.net.URLDecoder.decode(kv[0], StandardCharsets.UTF_8),
                               java.net.URLDecoder.decode(kv[1], StandardCharsets.UTF_8));
                }
            }

            String title = params.getOrDefault("title", "Untitled");
            String instructor = params.getOrDefault("instructor", "Staff");
            double price = Double.parseDouble(params.getOrDefault("price", "0.0"));

            int nextId = courseCatalog.size() + 1;
            courseCatalog.add(new Course(nextId, title, instructor, price));

            String responseMessage = "✔ Course '" + title + "' added successfully with ID #" + nextId;
            byte[] responseBytes = responseMessage.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(201, responseBytes.length); // 201 Created
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }
    }
}
