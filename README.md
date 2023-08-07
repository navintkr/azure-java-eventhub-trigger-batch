---
page_type: sample
languages:
- java
products:
- azure-functions
- azure
description: "This repository contains sample for Eventhub triggered Azure Functions in batch"
urlFragment: "azure-functions-java"
---

# Azure Functions samples in Java

This repository contains samples which show the basic usage of [Azure Functions](https://docs.microsoft.com/en-us/azure/azure-functions/) in Java for the below scenario.

| Scenario       | Description                                |
|-------------------|--------------------------------------------|
| [EventHubTrigger](./src/main/java/com/functions/EventHubTriggerFunction.java) | EventHubTrigger for message received in event grid and output to console.

## Contents

Outline the file contents of the repository. It helps users navigate the codebase, build configuration and any related assets.

| File/folder       | Description                                |
|-------------------|--------------------------------------------|
| `src`             | Sample source code.                        |
| `.gitignore`      | Define what to ignore at commit time.      |
| `pom.xml`         | The maven configuration to this sample.   |
| `README.md`       | This README file.                          

## Prerequisites

- mvn
- Latest [Function Core Tools](https://aka.ms/azfunc-install)
- Azure CLI. This plugin use Azure CLI for authentication, please make sure you have Azure CLI installed and logged in.

## Setup

- ```cmd
    az login
    az account set -s <your subscription id>
    ```
- Update the Application settings in Azure portal with the required parameters as below
  - AzureWebJobsStorage: Connection string to your storage account
  - EventHubConnectionString: Connection string to your Eventhub
  - Documentation on how to [manage connection strings](https://docs.microsoft.com/en-gb/azure/storage/common/storage-account-keys-manage?tabs=azure-portal) and [access keys](https://docs.microsoft.com/en-gb/azure/storage/common/storage-configure-connection-string#create-a-connection-string-for-an-azure-storage-account)
- Update `host.json` with the right extension bundle version. `V3 - [1.*, 2.0.0) and V4 - [2.*, 3.0.0)`


## Running the sample

```cmd
./mvnw clean package azure-functions:run
```

## Deploy the sample on Azure


```cmd
./mvnw clean package azure-functions:deploy
```


> NOTE: please replace '/' with '\\' when you are running on windows.


## Contributing

This project welcomes contributions and suggestions.  Most contributions require you to agree to a
Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us
the rights to use your contribution. For details, visit https://cla.opensource.microsoft.com.

When you submit a pull request, a CLA bot will automatically determine whether you need to provide
a CLA and decorate the PR appropriately (e.g., status check, comment). Simply follow the instructions
provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or
contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Telemetry
This project collects usage data and sends it to Microsoft to help improve our products and services.
Read Microsoft's [privacy statement](https://privacy.microsoft.com/en-us/privacystatement) to learn more.
If you would like to opt out of sending telemetry data to Microsoft, you can set `allowTelemetry` to false in the plugin configuration.
Please read our [document](https://github.com/microsoft/azure-gradle-plugins/wiki/Configuration) to find more details about *allowTelemetry*.