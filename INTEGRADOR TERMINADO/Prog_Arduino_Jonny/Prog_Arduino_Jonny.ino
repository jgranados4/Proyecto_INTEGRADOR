#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd(0x27,16,2);

long duracion, distancia;

#define echo_a 11 ///Integrador final terminado ultimate
#define trig_a A0

#define echo_b 8
#define trig_b A1

#define echo_c 5
#define trig_c A2

#define echo_d 2
#define trig_d A3

int espacio_a = 0;
int espacio_b = 0;
int espacio_c = 0;
int espacio_d = 0;

int ledPinV1 = 13;
int ledPinV2 = 10;
int ledPinV3 = 7;
int ledPinV4 = 4;

int ledPinR1 = 12;
int ledPinR2 = 9; 
int ledPinR3 = 6;
int ledPinR4 = 3;

int puestos=40;
void setup()
{
  Serial.begin(9600);

  pinMode(echo_a, INPUT);
  pinMode(trig_a, OUTPUT);
  pinMode(echo_b, INPUT);
  pinMode(trig_b, OUTPUT);
  pinMode(echo_c, INPUT);
  pinMode(trig_c, OUTPUT);
  pinMode(echo_d, INPUT);
  pinMode(trig_d, OUTPUT);
  
  pinMode(ledPinR1, OUTPUT);
  pinMode(ledPinV1, OUTPUT);
  pinMode(ledPinR2, OUTPUT);
  pinMode(ledPinV2, OUTPUT);
  pinMode(ledPinR3, OUTPUT);
  pinMode(ledPinV3, OUTPUT);
  pinMode(ledPinR4, OUTPUT);
  pinMode(ledPinV4, OUTPUT);
  
  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(2,0);
  lcd.print("Parqueo Goku");
  lcd.setCursor(0,1);
  lcd.print("Disponible:");
}

void loop()
{
  lcd.setCursor(11,1);
  
  lcd.print(puestos);
  lcd.print("/40");
  dist(echo_a,trig_a,ledPinR1,ledPinV1);
  dist(echo_b,trig_b,ledPinR2,ledPinV2);
  dist(echo_c,trig_c,ledPinR3,ledPinV3);
  dist(echo_d,trig_d,ledPinR4,ledPinV4);
}

void dist(int echo, int trig,int ledR,int ledV){
  digitalWrite(trig, LOW);
  delayMicroseconds(2);
  digitalWrite(trig, HIGH);
  delayMicroseconds(10);

  duracion = pulseIn(echo, HIGH);
  distancia = (duracion /2) / 29;

  //////////////////Condicionales/////////////////
  if(distancia < 10 && espacio_a == 0 && echo == 11) {
    puestos--;
    Serial.println("INGRESO_1");
    espacio_a = 1;
  }else if(distancia > 10 && espacio_a == 1 && echo == 11) {
    puestos++;
    espacio_a = 0;
  }
  ////////////////////////////////////////////////
  if(distancia < 10 && espacio_b == 0 && echo == 8) {
    puestos--;
    Serial.println("INGRESO_2");
    espacio_b = 1;
  }else if(distancia > 10 && espacio_b == 1 && echo == 8) {
    puestos++;
    espacio_b = 0;
  }
  ////////////////////////////////////////////////
  if(distancia < 10 && espacio_c == 0 && echo == 5) {
    puestos--;
    Serial.println("INGRESO_3");
    espacio_c = 1;
  }else if(distancia > 10 && espacio_c == 1 && echo == 5) {
    puestos++;
    espacio_c = 0;
  }
  ////////////////////////////////////////////////
  if(distancia < 10 && espacio_d == 0 && echo == 2) {
    puestos--;
    Serial.println("INGRESO_4");
    espacio_d = 1;
  }else if(distancia > 10 && espacio_d == 1 && echo == 2) {
    puestos++;
    espacio_d = 0;
  }
  ////////////////////////////////////////////////
  if(distancia < 10) {
    digitalWrite(ledR, HIGH);
    digitalWrite(ledV, LOW);
  }
  else {
    digitalWrite(ledR, LOW);
    digitalWrite(ledV, HIGH);
  }
}
