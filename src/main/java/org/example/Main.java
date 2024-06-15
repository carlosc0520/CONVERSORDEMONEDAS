package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        ventanaIngresarDatos();
    }

    public static void ventanaIngresarDatos() {
        JFrame frame1 = new JFrame("Conversión de Monedas");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 150);
        frame1.setResizable(false);
        frame1.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaMonto = new JLabel("Ingrese la cantidad de dinero que deseas convertir:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        frame1.add(etiquetaMonto, constraints);

        JTextField campoMonto = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        frame1.add(campoMonto, constraints);

        JButton botonCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        frame1.add(botonCancelar, constraints);

        JButton botonOK = new JButton("OK");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        frame1.add(botonOK, constraints);

        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });

        botonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double monto = Double.parseDouble(campoMonto.getText());
                    frame1.dispose();
                    ventanaTipoMoneda(monto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame1, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame1.setVisible(true);
    }

    public static void ventanaTipoMoneda(double monto) {
        JFrame frame2 = new JFrame("Monedas");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 150);
        frame2.setResizable(false);
        frame2.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaConversion = new JLabel("Elige la moneda a la que deseas convertir tu dinero:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        frame2.add(etiquetaConversion, constraints);

        String[] opciones = {
                "CONVERTIR SOLES A DOLAR",
                "CONVERTIR SOLES A EUROS",
                "CONVERTIR SOLES A YENES",
                "CONVERTIR SOLES A LIBRAS",
                "CONVERTIR SOLES A WON COREANO",
                "CONVERTIR DOLAR A SOLES",
                "CONVERTIR EUROS A SOLES",
                "CONVERTIR YENES A SOLES",
                "CONVERTIR LIBRAS A SOLES",
                "CONVERTIR WON COREANO A SOLES",
        };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        frame2.add(comboBox, constraints);

        JButton botonCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        frame2.add(botonCancelar, constraints);

        JButton botonOK = new JButton("OK");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        frame2.add(botonOK, constraints);

        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });

        botonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();

                frame2.dispose();
                ConsultaAPI converter = new ConsultaAPI();
                Double conversion = 0.0;
                switch (seleccion) {
                    case "CONVERTIR SOLES A DOLAR":
                        try {
                            conversion = converter.convertCurrency("PEN", "USD");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR SOLES A EUROS":
                        try {
                            conversion = converter.convertCurrency("PEN", "EUR");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR SOLES A YENES":
                        try {
                            conversion = converter.convertCurrency("PEN", "JPY");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR SOLES A LIBRAS":
                        try {
                            conversion = converter.convertCurrency("PEN", "GBP");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR SOLES A WON COREANO":
                        try {
                            conversion = converter.convertCurrency("PEN", "KRW");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR DOLAR A SOLES":
                        try {
                            conversion = converter.convertCurrency("USD", "PEN");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR EUROS A SOLES":
                        try {
                            conversion = converter.convertCurrency("EUR", "PEN");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR YENES A SOLES":
                        try {
                            conversion = converter.convertCurrency("JPY", "PEN");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR LIBRAS A SOLES":
                        try {
                            conversion = converter.convertCurrency("GBP", "PEN");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "CONVERTIR WON COREANO A SOLES":
                        try {
                            conversion = converter.convertCurrency("KRW", "PEN");
                        } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                }

                double resultado = monto * conversion;
                JOptionPane.showMessageDialog(frame2, "El resultado de la conversión es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                int respuesta = JOptionPane.showConfirmDialog(frame2, "¿Desea realizar otra conversión?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    ventanaIngresarDatos();
                } else {
                    JOptionPane.showMessageDialog(frame2, "Gracias por usar nuestro programa.", "CONVERSOR", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        frame2.setVisible(true);
    }


}

class ConsultaAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bfe0da309c2ebeac4ae27839/latest/";

    public double convertCurrency(String origin, String destination) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String requestUrl = API_URL + origin;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return conversionRates.get(destination).getAsDouble();
    }
}
