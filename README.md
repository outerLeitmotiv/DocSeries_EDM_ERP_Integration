# EDM_ERP_Integration

## Description
EDM_ERP_Integration is a small project that acts as a layer between an EDM (Document Enterprise Content Management) system, specifically Doc.ECM and an ERP (Enterprise Resource Planning) system, specifically OpenBravo. The purpose of this project is to fetch invoices from the EDM system based on their status and synchronize the status updates with the ERP system.

## Features
- Get credentials from the EDM
- Fetching invoices from the EDM system based on their status
- Integration with OpenBravo ERP system to update invoice status
- Automated synchronization of invoice status between the EDM and ERP systems

## How it works
The EDM_ERP_Integration project provides a set of functionalities to facilitate the integration between the EDM and ERP systems. Here's a high-level overview of how it works:

1. The project connects to the EDM system and retrieves invoices based on their status.
2. The fetched invoices are processed and any necessary transformations or data mappings are performed.
3. The processed invoices are then sent to the OpenBravo ERP system for further processing.
4. If an invoice is paid in the ERP system, the status update is synchronized back to the EDM system.

## Setup and Configuration
To set up the EDM_ERP_Integration project, follow these steps:

1. Clone the project repository from GitHub.
2. Install any required dependencies or libraries.
3. Configure the connection details for the EDM and ERP systems in the project's configuration file.
4. Build and deploy the project according to the deployment instructions provided.
5. Start the project and monitor the logs for any errors or issues.

## Requirements
- Doc.ECM EDM
- OpenBravo ERP system
- Java 8 or higher

