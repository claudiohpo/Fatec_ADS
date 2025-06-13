import { StatusBar } from "expo-status-bar";
import { View, Text, Image, Alert, ActivityIndicator } from "react-native";
import { styles } from "./styles";
import { theme } from "../../global/styles/theme";
import logoSmall from "../../../assets/app-name-small.png";
import { Button } from "../../components/Button";
import { TextInput } from "react-native-gesture-handler";
import { ButtonWhite } from "../../components/ButtonWhite";
import { useNavigation } from "@react-navigation/native";

export function Address2() {

 const navigation = useNavigation<any>();
 
   const handleNavigateBack = () => {
     navigation.navigate("Address");
   };
   
   const handleNavigateContinue = () => {
     navigation.navigate("PersonalData");
   };
 
   return (
     <View style={styles.container}>
       <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />
 
       <View style={styles.content}>
         <Text style={styles.title}>
           Para começar, insira seu endereço {"\n"}
         </Text>
 
        <Text style={styles.city2}> São Paulo, São Paulo, Brasil</Text>
 
       <View>
         <Text style={styles.label}>CEP * </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu CEP"
                   keyboardType="number-pad"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={6}
                 ></TextInput>
       </View>
 
       <View>
         <Text style={styles.label}>Endereço * </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu Endereço"
                   keyboardType="default"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={99}
                 ></TextInput>
       </View>
 
       <View>
         <Text style={styles.label}>Número * </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu número"
                   keyboardType="number-pad"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={10}
                 ></TextInput>
       </View>
 
       <View>
         <Text style={styles.label}>Complemento </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu complemento"
                   keyboardType="default"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={50}
                 ></TextInput>
       </View>    
 
       </View>
 
       <View style={styles.controlsbutons}>
         <Button title="Continuar" onPress={handleNavigateContinue}/>
         <Text>{"\n"}</Text>
         <ButtonWhite title="Voltar" onPress={handleNavigateBack}/>
       </View>
       
     </View>
  );
}
