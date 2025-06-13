import React from 'react';
import {
  View,
  Image
} from 'react-native';
import { useNavigation } from "@react-navigation/native";
import { styles } from './styles';
import logo from "../../assets/app-name-small.png";
import back from "../../assets/voltar.png";
import { RectButton, RectButtonProps } from 'react-native-gesture-handler';


export function LogoBack({ }) {

  const navigation = useNavigation<any>();

  const handleNavigate = () => {
    navigation.goBack();
  }

  return (
    <View style={styles.controls} >
      <RectButton
        style={styles.coluna1} onPress={handleNavigate}
      >
        <Image
          source={back}
          style={styles.coluna1}
        />

      </RectButton>
      <View style={styles.coluna2} >
        <Image
          source={logo}
        />
      </View>
    </View>
  );
}