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
import MaskInput from 'react-native-mask-input';

export function PersonalData() {

const [celular, setCelular] = useState('');
const [telefone, setTelefone] = useState('');

 const navigation = useNavigation<any>();
 
   const handleNavigateBack = () => {
     navigation.navigate("Address2");
   };
   
   const handleNavigateContinue = () => {
     navigation.navigate("AccountData");
   };
 
   return (
     <View style={styles.container}>
       <Image source={logoSmall} style={styles.imageLogo} resizeMode="stretch" />
 
       <View style={styles.content}>
         <Text style={styles.title}>
           Insira seus dados pessoais {"\n"}
         </Text>
 
       <View>
         <Text style={styles.label}>Nome * </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu nome"
                   keyboardType="default"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={99}
                 ></TextInput>
       </View>
 
       <View>
         <Text style={styles.label}>Sobrenome * </Text>
         <TextInput
                   style={styles.input}
                   placeholder="Insira seu Sobrenome"
                   keyboardType="default"
                   placeholderTextColor={theme.colors.primary}
                   maxLength={99}
                 ></TextInput>
       </View>
 
       <View>
      <Text style={styles.label}>Celular *</Text>

      <MaskInput
        style={styles.input}
        value={celular}
        onChangeText={setCelular}
        keyboardType="number-pad"
        placeholder="Insira seu celular com DDD"
        placeholderTextColor={theme.colors.primary}
        mask={['(', /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]}
      />
    </View>
 
       <View>
         <Text style={styles.label}>Telefone </Text>
         <MaskInput
        style={styles.input}
        value={telefone}
        onChangeText={setTelefone}
        keyboardType="number-pad"
        placeholder="Insira seu telefone com DDD"
        placeholderTextColor={theme.colors.primary}
        mask={['(', /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]}
      />
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
