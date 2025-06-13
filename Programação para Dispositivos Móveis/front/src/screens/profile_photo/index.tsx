import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator} from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { TextInput, TouchableOpacity } from "react-native-gesture-handler";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";
import Photo from "../../../assets/Profile_photo.png";
import * as ImagePicker from 'expo-image-picker';


export function ProfilePhoto() {
  const navigation = useNavigation<any>();

  const [photoUri, setPhotoUri] = useState<string | null>(null);


  const handleNavigateContinue = () => {
    navigation.navigate("ProfileCreated");
  };

  return (
    <View style={styles.container}>
      <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />
      <Text style={styles.title}>
        Seu perfil foi criado com sucesso! {"\n"}
      </Text>

      {/* Se já escolheu uma foto, exibe; senão exibe a padrão */}
      <Image 
        source={ photoUri ? { uri: photoUri } : require("../../../assets/Profile_photo.png") } 
        style={styles.image} 
        resizeMode="cover" 
      />

      <View style={styles.content}>
        {/* ← TORNEI ESTE TRECHO CLICÁVEL */}
        <TouchableOpacity onPress={pickImage}>
          <Text style={styles.subtitle}>
            Selecionar foto de perfil{"\n"}
          </Text>
        </TouchableOpacity>
      </View>

      <View style={styles.controlsbutons}>
        <Button title="Continuar" onPress={handleNavigateContinue} />
        <Text>{"\n"}</Text>
        <ButtonWhite title="Pular esta etapa" onPress={handleNavigateContinue} />
      </View>
    </View>
  );
}
