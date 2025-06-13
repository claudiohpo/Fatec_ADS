import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import apple from "../../../assets/apple.png";
import facebook from "../../../assets/facebook.png";
import google from "../../../assets/google.png";
import linha from "../../../assets/linha.png";
import { Button } from "../../components/Button";
import { TextInput } from "react-native-gesture-handler";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";
import React, { useState } from "react";

export function Password() {

  const navigation = useNavigation<any>();

  const [email, setEmail] = useState("");

  const handleNavigateHome = () => {
    navigation.navigate("Home");
  };

  const handleNavigateSignIn = () => {
    navigation.navigate("SignIn");
  };

  const handleNavigateCheckEmail = () => {
    if (email.trim() === "") {
      Alert.alert("Erro", "Campo e-mail vazio, insira seu e-mail e tente novamente.");
      return;
    }

    const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!regexEmail.test(email)) {
      Alert.alert("Erro", "Formato de e-mail inválido.");
      return;
    }

    navigation.navigate("CheckEmail");
  };

  const handleNavigateConfirm = () => {
    navigation.navigate("Confirm");
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />

      <View style={styles.content}>
        <Text style={styles.title}>
          Esqueceu a senha {"\n"}
        </Text>

        <Text style={styles.label}>Informe seu e-mail abaixo: {"\n"}</Text>
        <TextInput
          style={styles.input}
          placeholder="Insira seu e-mail"
          keyboardType="email-address"
          placeholderTextColor={theme.colors.primary}
          maxLength={20}
          value={email} 
          onChangeText={setEmail}
        ></TextInput>
        
      </View>

      <View style={styles.controlsbutons}>
        <Button title="Continuar" onPress={handleNavigateCheckEmail}/>
        <Text>{"\n"}</Text>
        <ButtonWhite title="Voltar" onPress={handleNavigateSignIn}/>
      </View>
      
    </View>
  );
}