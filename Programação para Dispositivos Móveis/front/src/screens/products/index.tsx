import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { TextInput } from "react-native-gesture-handler";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";
import { useState } from "react";


export function Products() {
  
  const navigation = useNavigation<any>();

 const produtos = [
    {
      id: "1",
      nome: "MacBook Air de 13”",
      preco: "R$ 7.999,99",
      loja: "Loja SiteX Eletrônicos",
      imagem: macbookImg,
    },
    {
      id: "2",
      nome: "PC Gamer EasyPC",
      preco: "R$ 3.599,99",
      loja: "Loja SiteX Eletrônicos",
      imagem: pcImg,
    },
    {
      id: "3",
      nome: "Headset HyperX",
      preco: "R$ 299,99",
      loja: "Loja SiteX Eletrônicos",
      imagem: headsetImg,
    },
  ];

  
  return (
    <View style={styles.container}>
      {/* <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" /> */}

      <View style={styles.content}>
        <Text style={styles.title}>Home {"\n"}</Text>

        </View>

      <View style={styles.controlsbutons}>
        {/* <Button title="Continuar" onPress={handleNavigateCheckEmail} /> */}
        <Text>{"\n"}</Text>
        {/* <ButtonWhite title="Voltar" onPress={handleNavigateBack} /> */}
      </View>
    </View>
  );
}
