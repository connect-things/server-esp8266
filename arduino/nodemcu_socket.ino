#include <ESP8266WiFi.h>

const char* ssid     = "Iot";
const char* password = "12345678";

const char* host = "192.168.0.100";
const int port = 9000;

int number = 0;

WiFiClient CLIENT;

void setup() {
  Serial.begin(115200);
  delay(10);

  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");  
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}


void loop() {
  number++;

  Serial.print("connecting to ");
  Serial.println(host);
  
  // Use WiFiClient class to create TCP connections
  WiFiClient client;
  if (!client.connect(host, port)) {
    Serial.println("connection failed");
    return;
  }
  
  // This will send the request to the server
  client.print(String("CONECTOU ") + String(number));
  client.stop();
  delay(5000);
}
