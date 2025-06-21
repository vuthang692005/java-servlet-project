package com.example;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

        assertTrue(output.contains("Chào mừng bạn đến với dự án Java Servlet!"));
        assertTrue(output.contains("<h1>"));
        assertTrue(output.contains("</html>"));
    }
}

