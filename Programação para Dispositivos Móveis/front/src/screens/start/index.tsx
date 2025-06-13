import { StatusBar } from "expo-status-bar";
import { View, Text, Image } from "react-native";
import { styles } from "./styles";
import IllustrationImg from "../../../assets/Ilustration.png";
import logoSmall from "../../../assets/LogoSmall.png";
import { ButtonWhite } from "../../components/ButtonWhite";
import { Background } from "../../components/Background";

import { useNavigation, useFocusEffect } from "@react-navigation/native";

export function Start() {
  const navigation = useNavigation<any>();

  const handleNavigate = () => {
    navigation.navigate("SignIn");
    // navigation.goBack();
  };

  return (
    <Background>
      <View style={styles.container}>
        <Image
          source={logoSmall}
          style={styles.imageLogo}
          resizeMode="stretch"
        />
        <Text style={styles.title}>
          Marketplace {"\n"} Inteligente para você {"\n"}
        </Text>
        <Image
          source={IllustrationImg}
          style={styles.image}
          resizeMode="stretch"
        />

        <View style={styles.content}>
          <Text style={styles.subtitle}>
            Sua solução para vender seus produtos {"\n"}
          </Text>

          <ButtonWhite title="Continuar" onPress={handleNavigate} />
        </View>
      </View>
    </Background>
  );
}
