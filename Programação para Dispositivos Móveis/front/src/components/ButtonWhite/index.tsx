import React from 'react';
import { Text, Image, View, ImageBackground } from 'react-native';
import { RectButton, RectButtonProps } from 'react-native-gesture-handler';

import { styles } from './styles';

type Props = RectButtonProps & {
  title: string,
  onPress?: () => void;
}

export function ButtonWhite({ title, ...rest }: Props) {
  return (
    <RectButton
      style={styles.container}
      {...rest}
    >
      <Text style={styles.title}>
        {title}
      </Text>
    </RectButton>
  );
}