package lab10.prob1.bugreporter;

import lab10.prob1.classfinder.ClassFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class scans the package lesson10.labs.prob2.javapackage for classes with
 * annotation @BugReport. It then generates a bug report bugreport.txt,
 * formatted like this:
 * <p>
 * Joe Smith reportedBy: classname: description: severity:
 * <p>
 * reportedBy: classname: description: severity:
 * <p>
 * Tom Jones reportedBy: classname: description: severity:
 * <p>
 * reportedBy: classname: description: severity:
 */
public class BugReportGenerator {

    private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
    private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob1.javapackage";
    private static final String REPORT_NAME = "bug_report.txt";
    private static final String REPORTED_BY = "reportedBy: ";
    private static final String CLASS_NAME = "classname: ";
    private static final String DESCRIPTION = "description: ";
    private static final String SEVERITY = "severity: ";

    public void reportGenerator() {
        List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);

        Map<String, List<String>> bugsByFixer = new HashMap<>();

        for (Class<?> cl : classes) {
            if (cl.isAnnotationPresent(BugReport.class)) {
                BugReport annotation = cl.getAnnotation(BugReport.class);

                // Extract details
                String fixerName = annotation.assignedTo();
                String bugDetails = String.format("\tClass: %s,\n\tReported By: %s,\n\tSeverity: %s,\n\tDescription: %s\n",
                        cl.getSimpleName(),
                        annotation.reportedBy(),
                        annotation.severity(),
                        annotation.description());

                // Group by fixer name
                bugsByFixer.computeIfAbsent(
                        fixerName, k -> new ArrayList<>()).add(bugDetails);
            }
        }

        //
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : bugsByFixer.entrySet()) {
            result.append("Bug Fixer: ").append(entry.getKey()).append("\n");
            entry.getValue().forEach(bug -> result.append(bug).append("\n"));
            result.append("\n"); // Add a blank line for separation
        }

        //  Write the report to a file
        try (PrintWriter writer = new PrintWriter(new FileWriter(REPORT_NAME))) {
            writer.write(result.toString());
            System.out.println("\nBug report successfully written to: " + REPORT_NAME);
        } catch (IOException e) {
            System.err.println("\nError writing to file: " + e.getMessage());
        }

    }
}
