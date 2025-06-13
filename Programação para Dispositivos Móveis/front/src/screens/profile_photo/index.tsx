import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";
import Photo from "../../../assets/Profile_photo.png";

export function ProfilePhoto() {
  const navigation = useNavigation<any>();

  const handleNavigateContinue = () => {
    navigation.navigate("ProfileCreated");
  };

  const handlePress = () => {
    Alert.alert(
      "Selecionar foto de perfil",
      "Você deseja selecionar uma foto de perfil?",
      [
        {
          text: "Cancelar",
          style: "cancel",
        },
        {
          text: "OK",
          onPress: () => console.log("OK Pressed"),
        },
      ]
    );
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />
      <Text style={styles.title}>
        Seu perfil foi criado com sucesso! {"\n"}
      </Text>

      <Image source={Photo} style={styles.image} resizeMode="stretch" />

      <View style={styles.content}>
        <Text
          style={[
            styles.subtitle,
            { color: "#007BFF", textDecorationLine: "underline" },
          ]}
          onPress={handlePress}
        >
          {" "}
          Selecionar foto de perfil
        </Text>
      </View>

      <View style={styles.controlsbutons}>
        <Button title="Continuar" onPress={handleNavigateContinue} />
        <Text>{"\n"}</Text>
        <ButtonWhite
          title="Pular esta etapa"
          onPress={handleNavigateContinue}
        />
      </View>
    </View>
  );
}
