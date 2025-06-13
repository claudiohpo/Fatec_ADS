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

export function AccountData() {
  const [celular, setCelular] = useState("");
  const [telefone, setTelefone] = useState("");

  const navigation = useNavigation<any>();

  const [email, setEmail] = useState("");

  const handleNavigateBack = () => {
    navigation.navigate("PersonalData");
  };

  const handleNavigateCheckEmail = () => {
    if (email.trim() === "") {
      Alert.alert(
        "Erro",
        "Campo e-mail vazio, insira seu e-mail e tente novamente."
      );
      return;
    }

    const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!regexEmail.test(email)) {
      Alert.alert("Erro", "Formato de e-mail inválido.");
      return;
    }

    navigation.navigate("ProfilePhoto");
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />

      <View style={styles.content}>
        <Text style={styles.title}>Insira os dados da sua conta {"\n"}</Text>

        <View>
          <Text style={styles.label}>Email * </Text>
          <TextInput
            style={styles.input}
            placeholder="Insira seu email"
            keyboardType="email-address"
            placeholderTextColor={theme.colors.primary}
            maxLength={99}
            value={email}
            onChangeText={setEmail}
          ></TextInput>
        </View>

        <View>
          <Text style={styles.label}>Nome de Usuário * </Text>
          <TextInput
            style={styles.input}
            placeholder="Insira seu Nome de Usuário"
            keyboardType="default"
            placeholderTextColor={theme.colors.primary}
            maxLength={25}
          ></TextInput>
        </View>

        <View>
          <Text style={styles.label}>Senha *</Text>

          <TextInput
            style={styles.input}
            keyboardType="number-pad"
            placeholder="Insira sua senha (apenas numeros)"
            maxLength={6}
            secureTextEntry
            placeholderTextColor={theme.colors.primary}
          ></TextInput>
        </View>

        <View>
          <Text style={styles.label}>Confirme a senha *</Text>

          <TextInput
            style={styles.input}
            keyboardType="number-pad"
            placeholder="Confirme sua senha (apenas numeros)"
            maxLength={6}
            secureTextEntry
            placeholderTextColor={theme.colors.primary}
          ></TextInput>
        </View>
      </View>

      <View style={styles.controlsbutons}>
        <Button title="Continuar" onPress={handleNavigateCheckEmail} />
        <Text>{"\n"}</Text>
        <ButtonWhite title="Voltar" onPress={handleNavigateBack} />
      </View>
    </View>
  );
}
