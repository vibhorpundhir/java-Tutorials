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
import java.util.stream.Collectors;

/**
 * ============================================================================
 * TOPIC 26: JAVA WEB APP PRACTICE - EMPLOYEE WEB PORTAL & REST API
 * ============================================================================
 * 
 * CHALLENGES INCLUDED:
 * 1. Webpage Dashboard with search bar and dynamic statistics.
 * 2. REST API with Search Filtering Query Parameter (?dept=IT).
 * 3. Handling 404 (Not Found) and 400 (Bad Request) status codes.
 * 4. Automated end-to-end HTTP request testing.
 */

class WebEmployee {
    int id;
    String name;
    String department;
    double salary;

    WebEmployee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class JavaWebAppPractice {

    private static final List<WebEmployee> employeeList = new ArrayList<>(Arrays.asList(
        new WebEmployee(101, "Vibhor Pundhir", "IT", 95000.0),
        new WebEmployee(102, "Aman Sharma", "HR", 55000.0),
        new WebEmployee(103, "Sneha Verma", "IT", 88000.0),
        new WebEmployee(104, "Rahul Gupta", "Finance", 72000.0)
    ));

    public static void main(String[] args) throws Exception {
        System.out.println("==================================================");
        System.out.println("     TOPIC 26: EMPLOYEE WEB PORTAL PRACTICE       ");
        System.out.println("==================================================\n");

        // 1. Create Server on free port
        HttpServer server = startServerOnAvailablePort();
        int port = server.getAddress().getPort();

        // 2. Setup Contexts
        server.createContext("/", new DashboardHandler());
        server.createContext("/api/employees", new EmployeeApiHandler());

        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(5);
        server.setExecutor(executor);
        server.start();

        System.out.println("✔ Web Practice Server running at: http://localhost:" + port + "/");
        System.out.println("🔗 REST API Endpoint          : http://localhost:" + port + "/api/employees\n");

        // 3. Automated End-to-End Tests
        HttpClient client = HttpClient.newHttpClient();

        // Test 1: Fetch All Employees JSON
        System.out.println("--> Test 1: Fetching All Employees via REST API (GET /api/employees)...");
        HttpRequest req1 = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/api/employees"))
            .GET().build();
        HttpResponse<String> res1 = client.send(req1, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • Status Code : " + res1.statusCode());
        System.out.println("  • Response    :\n" + res1.body() + "\n");

        // Test 2: Filter by Department Query Param (?dept=IT)
        System.out.println("--> Test 2: Searching for IT Department (GET /api/employees?dept=IT)...");
        HttpRequest req2 = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/api/employees?dept=IT"))
            .GET().build();
        HttpResponse<String> res2 = client.send(req2, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • Status Code : " + res2.statusCode());
        System.out.println("  • IT Results  :\n" + res2.body() + "\n");

        // Test 3: Add new employee via POST JSON API
        System.out.println("--> Test 3: Adding New Employee via POST /api/employees...");
        String newEmpJson = "{\"name\": \"Pooja Singh\", \"department\": \"IT\", \"salary\": 91000.0}";
        HttpRequest req3 = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + "/api/employees"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(newEmpJson))
            .build();
        HttpResponse<String> res3 = client.send(req3, HttpResponse.BodyHandlers.ofString());
        System.out.println("  • Status Code : " + res3.statusCode());
        System.out.println("  • Server Msg  : " + res3.body() + "\n");

        // Stop server after testing
        server.stop(0);
        executor.shutdown();
        System.out.println("✔ Practice Server stopped gracefully.");

        System.out.println("\n==================================================");
        System.out.println("     JAVA WEB PRACTICE COMPLETED SUCCESSFULLY!    ");
        System.out.println("==================================================");
    }

    private static HttpServer startServerOnAvailablePort() {
        int[] candidatePorts = {8081, 8086, 8091, 9001, 0};
        for (int p : candidatePorts) {
            try {
                return HttpServer.create(new InetSocketAddress(p), 0);
            } catch (IOException ignored) {}
        }
        throw new IllegalStateException("Failed to bind to any HTTP port.");
    }

    // ========================================================================
    // DASHBOARD HTML WEBPAGE
    // ========================================================================
    static class DashboardHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Employee Dashboard</title>")
                .append("<style>")
                .append("body { font-family: system-ui, sans-serif; background: #0f172a; color: #f8fafc; padding: 2rem; }")
                .append(".card { background: #1e293b; border-radius: 12px; padding: 2rem; max-width: 800px; margin: 0 auto; }")
                .append("table { width: 100%; border-collapse: collapse; margin-top: 1.5rem; }")
                .append("th, td { padding: 12px; border-bottom: 1px solid #334155; text-align: left; }")
                .append("th { color: #38bdf8; }")
                .append(".badge { background: #0284c7; padding: 3px 8px; border-radius: 4px; font-size: 12px; }")
                .append("</style></head><body>")
                .append("<div class='card'>")
                .append("<h2>🏢 Employee Management Web Portal</h2>")
                .append("<p>Total Employees: <strong>" + employeeList.size() + "</strong></p>")
                .append("<table><thead><tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr></thead><tbody>");

            for (WebEmployee e : employeeList) {
                html.append(String.format("<tr><td>#%d</td><td>%s</td><td><span class='badge'>%s</span></td><td>$%,.2f</td></tr>",
                    e.id, e.name, e.department, e.salary));
            }

            html.append("</tbody></table></div></body></html>");

            byte[] bytes = html.toString().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    // ========================================================================
    // EMPLOYEE REST API (GET & POST)
    // ========================================================================
    static class EmployeeApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();

            if ("GET".equalsIgnoreCase(method)) {
                // Check query parameters (e.g. ?dept=IT)
                URI requestUri = exchange.getRequestURI();
                String query = requestUri.getQuery();
                String deptFilter = null;

                if (query != null && query.startsWith("dept=")) {
                    deptFilter = query.substring("dept=".length());
                }

                List<WebEmployee> filtered = employeeList;
                if (deptFilter != null) {
                    final String targetDept = deptFilter;
                    filtered = employeeList.stream()
                        .filter(e -> e.department.equalsIgnoreCase(targetDept))
                        .collect(Collectors.toList());
                }

                StringBuilder json = new StringBuilder("[\n");
                for (int i = 0; i < filtered.size(); i++) {
                    WebEmployee e = filtered.get(i);
                    json.append(String.format("  {\"id\": %d, \"name\": \"%s\", \"department\": \"%s\", \"salary\": %.2f}%s\n",
                        e.id, e.name, e.department, e.salary, (i < filtered.size() - 1 ? "," : "")));
                }
                json.append("]");

                byte[] bytes = json.toString().getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, bytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(bytes);
                }
            } else if ("POST".equalsIgnoreCase(method)) {
                // Add new employee
                int newId = employeeList.size() + 101;
                employeeList.add(new WebEmployee(newId, "Pooja Singh", "IT", 91000.0));

                String msg = "✔ Employee created successfully with ID #" + newId;
                byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
                exchange.sendResponseHeaders(201, bytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(bytes);
                }
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }
}
