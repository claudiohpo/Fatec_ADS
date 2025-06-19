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
import EmailImg from "../../../assets/Email.png";

export function CheckEmail() {
  const navigation = useNavigation<any>();

  const handleNavigateSignIn = () => {
    navigation.navigate("SignIn");
  };

  
  return (
    
      <View style={styles.container}>
        <Image
          source={logoSmall}
          style={styles.imageLogo}
          resizeMode="stretch"
        />
        <Text style={styles.title}>
          Confira seu e-mail {"\n"}
        </Text>
        <Image
          source={EmailImg}
          style={styles.image}
          resizeMode="stretch"
        />

        <View style={styles.content}>
          <Text style={styles.subtitle}>
            Enviamos as instruções em seu e-mail
          para restaurar a sua senha. {"\n"}
          </Text>

          <Button title="Entrar" onPress={handleNavigateSignIn} />
        </View>
      </View>
    
  );
}
