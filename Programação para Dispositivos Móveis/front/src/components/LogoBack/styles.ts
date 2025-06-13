import { version } from 'react';
import { StyleSheet } from 'react-native';
import { theme } from '../../global/styles/theme';

export const styles = StyleSheet.create({
  controls: {
    marginTop: 0,
    justifyContent: 'space-evenly',
    flexDirection: 'row',
    width: '100%',
    paddingHorizontal: 10,
    marginBottom: 30

  },
  coluna1: {
    width: 60,
    height: 60,
    zIndex: 2,
    alignItems: 'center',
    position: 'absolute',
    left: 10,
    top: -7
  },
  coluna2: {
    zIndex: 1,
    width: '100%',
    borderColor: theme.colors.primary,
    alignItems: 'center'
  },
});