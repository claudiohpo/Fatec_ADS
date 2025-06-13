import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { useNavigation } from "@react-navigation/native";
import Like from "../../../assets/like.png";

export function ProfileCreated() {
  const navigation = useNavigation<any>();

  const handleNavigateSignIn = () => {
    navigation.navigate("SignIn");
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />
      <Text style={styles.title}>
        Seu perfil foi criado com sucesso! {"\n"}
      </Text>
      <Image source={Like} style={styles.image} resizeMode="stretch" />

      <View style={styles.content}>
        <Text style={styles.subtitle}>
          Realize o login com as credenciais inseridas nos passos anteriores.{" "}
          {"\n"}
        </Text>

        <Button title="Entrar" onPress={handleNavigateSignIn} />
      </View>
    </View>
  );
}