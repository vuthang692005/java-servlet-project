package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class HelloServletTest {

    @Test
    void testDoGet_outputsCorrectHtml() throws IOException, ServletException {
        // Arrange
        HelloServlet servlet = new HelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter);

        // Act
        servlet.doGet(request, response);

        // Assert
        printWriter.flush(); // Ensure everything is written to the StringWriter
        String output = stringWriter.toString();

        assertTrue(output.contains("Chào mừng bạn đến với dự án Java Servlet của chúng tôi!"));
        assertTrue(output.contains("<h1>"));
        assertTrue(output.contains("</html>"));
    }
}

