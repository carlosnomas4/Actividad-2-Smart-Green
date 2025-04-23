package ar.edu.udeci.pv;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SmartGreenApp {
    private static final Logger logger = LogManager.getLogger(SmartGreenApp.class);
    private static final String DEFAULT_MAX_TEMP = "30"; // Temperatura máxima por defecto

    public static void main(String[] args) {
        Options options = new Options();

        Option maxTempOption = new Option("t", "max-temp", true, "Temperatura máxima para activar la alerta (°C)");
        maxTempOption.setRequired(false); // No es obligatorio
        options.addOption(maxTempOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
            logger.info("Argumentos de línea de comandos analizados.");
        } catch (ParseException e) {
            logger.error("Error al analizar los argumentos: " + e.getMessage());
            formatter.printHelp("smart_green", options);
            System.exit(1);
        }

        String maxTemperatureStr = cmd.getOptionValue("max-temp", DEFAULT_MAX_TEMP);
        int maxTemperature = Integer.parseInt(maxTemperatureStr);
        logger.info("Temperatura máxima configurada: " + maxTemperature + " °C");

        System.out.println("Bienvenido a Smart Green!");
        System.out.println("Controlando la temperatura del jardín y el riego...");
        System.out.println("Se enviará una alerta si la temperatura supera los " + maxTemperature + " °C.");

        // Aquí iría la lógica para leer la temperatura del jardín
        double currentTemperature = 25.0; // Simulación de temperatura actual

        logger.info("Temperatura actual del jardín: " + currentTemperature + " °C");

        if (currentTemperature > maxTemperature) {
            logger.warn("⚠️⚠️¡Alerta de alta temperatura! La temperatura actual (" + currentTemperature + " °C) supera el límite configurado (" + maxTemperature + " °C).");
            System.out.println("⚠️⚠️¡ALERTA! Temperatura alta detectada: " + currentTemperature + " °C.");
            // Aquí se enviaría la notificación al usuario
        } else {
            logger.info("La temperatura actual (" + currentTemperature + " °C) está dentro del rango normal✅.");
        }

        // Aquí iría la lógica para controlar el riego (simulado por ahora)
        boolean shouldWater = false; // Decisión basada en algún criterio
        if (shouldWater) {
            logger.info("Activando el riego💧 ");
            System.out.println("Riego activado💧 ");
            // Aquí se accionaría el riego
        } else {
            logger.info("✅El riego no es necesario por el momento.");
            System.out.println("El riego no se activará.");
        }
    }
}