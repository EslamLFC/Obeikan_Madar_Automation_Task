## Obeikan Madar Automation Task
This project automates the complete shopping flow for video games on Amazon Egypt (amazon.eg) using Selenium-Java with Page Object Model design pattern 
# Architecture
- Design Pattern: Page Object Model (POM)
- Pages: Separate page classes for each webpage 
- Utils: Reusable utility classes for waits and configuration
- Tests: Test classes using TestNG framework
- Configuration Management:
    * External configuration file
    * Easy to modify test parameters
    * Credentials separated from code
#  Requirements
Before running the project, ensure you have the following installed:
1. Java JDK 11 or higher
2. Apache Maven 3.6+
3. Chrome Web Browser
# Dependencies
All dependencies are managed by Maven and will be automatically downloaded:
- Selenium WebDriver 4.25.0: Browser automation
- TestNG 7.10.2: Testing framework
