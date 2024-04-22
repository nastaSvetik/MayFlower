#Use base image with maven and jdk
FROM maven:3-openjdk-17-slim

# Install system apps for futher work
RUN apt-get update && apt-get install -y \
    wget \
    unzip\
    gnupg

# Set the working directory
WORKDIR /app

# Copy the project into the container at /app
COPY . /app

# Install maven dependencies
RUN mvn dependency:go-offline

# Download and install latest google-chrome (version 123)
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/* \

# Download appropriate chrome-driver
RUN wget https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chromedriver-linux64.zip -O /tmp/chromedriver.zip \
    && unzip /tmp/chromedriver.zip -d /app/ \
    && rm /tmp/chromedriver.zip \

# Set path to chrome-driver
ENV pathToChromeDriver=/app/chromedriver-linux64/chromedriver

# Download allure
RUN  wget -O allure.zip https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.17.0/allure-commandline-2.17.0.zip \
     && unzip allure.zip -d /opt \
     && ln -s /opt/allure-2.17.0/bin/allure /usr/bin/allure \
     && rm allure.zip

# Run the application
#CMD ["sleep", "infinity"]
CMD ["sh", "-c", "mvn clean test || true && allure serve ./target/allure-results --port 8003"]

