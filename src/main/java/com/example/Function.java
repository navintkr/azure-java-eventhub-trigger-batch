package com.example;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.*;

public class Function {

    //Generate random data in eventhub every second
    @FunctionName("generateSensorData")
    @EventHubOutput(name = "event", eventHubName = "", // blank because the value is included in the connection string
            connection = "EventHubConnectionString")
    public TelemetryItem generateSensorData(
            @TimerTrigger(name = "timerInfo", schedule = "*/1 * * * * *") // every 10 seconds
            String timerInfo,
            final ExecutionContext context) {

        context.getLogger().info("Java Timer trigger function executed at: "
                + java.time.LocalDateTime.now());
        double temperature = Math.random() * 100;
        double pressure = Math.random() * 50;
        return new TelemetryItem(temperature, pressure);
    }
    //recieve in batch along with system properties
    @FunctionName("EventHubReceiver")
    public void run(
            @EventHubTrigger(name = "message", eventHubName = "", consumerGroup = "$Default", connection = "EventHubConnectionString", cardinality = Cardinality.MANY) String message,
            @BindingName("SystemPropertiesArray") SystemProperty[] systemPropertiesArray,
            final ExecutionContext context) {
        context.getLogger().info("Java Event Hub trigger function executed." + message);
        context.getLogger()
                .info("SystemProperties for message[0]: EnqueuedTimeUtc=" + systemPropertiesArray[0].EnqueuedTimeUtc
                        + " Offset=" + systemPropertiesArray[0].Offset + " PartitionKey="
                        + systemPropertiesArray[0].PartitionKey);
    }

    public static class SystemProperty {
        public String SequenceNumber;
        public String Offset;
        public String PartitionKey;
        public String EnqueuedTimeUtc;
    }

}