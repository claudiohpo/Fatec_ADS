import { StyleSheet } from 'react-native';
import { theme } from '../../global/styles/theme';

export const styles = StyleSheet.create({
  container: {
    width: '100%',
    height: 56,
    backgroundColor: theme.colors.heading,
    borderRadius: 18,
    flexDirection: 'row',
    alignItems: 'center'
  },
  title: {
    flex: 1,
    color: theme.colors.secondary100,
    fontFamily: theme.fonts.text500,
    fontSize: 20,
    fontWeight: 'bold',
    textAlign: 'center',
  }

});