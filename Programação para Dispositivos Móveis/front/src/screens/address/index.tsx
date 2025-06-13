import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { TextInput } from "react-native-gesture-handler";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";
import React, { useState } from "react";

export function Address() {

  const navigation = useNavigation<any>();

  const handleNavigateSignIn = () => {
    navigation.navigate("SignIn");
  };
  
  const handleNavigateContinue = () => {
    navigation.navigate("Address2"); //mudar para a proxima tela (usar a tela confirm)
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />

      <View style={styles.content}>
        <Text style={styles.title}>
          Para começar, insira seu endereço {"\n"}
        </Text>

        
        <TextInput
          style={styles.input}
          placeholder="Insira sua cidade"
          keyboardType="default"
          placeholderTextColor={theme.colors.primary}
          maxLength={30}
        ></TextInput>
        
      <View>
        <Text style={styles.city}>São Paulo, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Atual {"\n"}</Text>
      </View>

      <View>
        <Text style={styles.city}>São Bernardo do Campo, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Aproximada {"\n"}</Text>
      </View>

      <View>
        <Text style={styles.city}>Guarulhos, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Atual {"\n"}</Text>
      </View>

      <View>
        <Text style={styles.city}>Osasco, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Aproximada {"\n"}</Text>
      </View>    

      <View>
        <Text style={styles.city}>Santo André, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Aproximada {"\n"}</Text>
      </View>   

      <View>
        <Text style={styles.city}>São Caetano do Sul, São Paulo, Brasil </Text>
        <Text style={styles.location}>Localização Aproximada {"\n"}</Text>
      </View>   
      </View>

      <View style={styles.controlsbutons}>
        <Button title="Continuar" onPress={handleNavigateContinue}/>
        <Text>{"\n"}</Text>
        <ButtonWhite title="Voltar" onPress={handleNavigateSignIn}/>
      </View>
      
    </View>
  );
}