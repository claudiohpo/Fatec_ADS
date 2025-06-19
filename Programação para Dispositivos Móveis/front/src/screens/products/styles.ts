import { Dimensions, StyleSheet } from 'react-native';
import { theme } from '../../global/styles/theme';

const { width } = Dimensions.get("window");

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 15,
    alignItems: 'center',
    backgroundColor: theme.colors.white,
    width: '100%'
  },
  containerTitle: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    width: '100%',
    paddingHorizontal: 15,
  },
  containerSubtitle: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    width: '100%',
    paddingHorizontal: 15,
    paddingTop: 30,
    paddingBottom: 5,
  },
  imageBanner: {
    width: '100%',
    alignContent: 'center',
    height: 180,
  },
  label: {
    color: theme.colors.primary,
    fontFamily: theme.fonts.text500,
    fontSize: 10,
    textAlign: 'right',
  },
  input: {
    color: theme.colors.text,
    fontFamily: theme.fonts.text400,
    fontSize: 10,
    textAlign: 'right',
    borderBottomColor: theme.colors.primary,
  },
  content: {
    marginTop: 0,
    width: '100%',
    paddingHorizontal: 5,
  },
  content2: {
    marginTop: 0,
    width: '100%',
    paddingHorizontal: 5,
    marginBottom: 160,
  },
  title: {
    color: theme.colors.text,
    textAlign: 'left',
    fontSize: 25,
    fontWeight: 'bold',
    marginBottom: 5,
    fontFamily: theme.fonts.title700,
    lineHeight: 40
  },
  imageLogo: {
    marginTop: 0,
    marginBottom: 15
  },
  linha: {
    marginTop: 15,
    marginBottom: 15
  },
  subtitle: {
    color: theme.colors.text,
    fontSize: 15,
    textAlign: 'left',
    fontFamily: theme.fonts.title500,
    lineHeight: 25
  },
  city: {
    color: theme.colors.secondary90,
    fontFamily: theme.fonts.text400,
    fontSize: 15,
    fontWeight: 'bold',
    textAlign: 'left',
    marginBottom: 10
  },
  location: {
    color: theme.colors.primary,
    fontFamily: theme.fonts.text400,
    fontSize: 12,
    textAlign: 'left',
    marginBottom: 15
  },
  city2: {
    color: theme.colors.secondary90,
    fontFamily: theme.fonts.text400,
    fontSize: 15,
    fontWeight: 'bold',
    textAlign: 'left',
    marginBottom: 10,
    borderBottomColor: theme.colors.primary,
    borderBottomWidth: 2
  },
  productList: {
    alignSelf: 'flex-start',
  },
  productCard: {
    width: 140,
    marginRight: 16,
    alignItems: 'center',
  },
  productImage: {
    width: "100%",
    height: 100,
    borderRadius: 8,
  },
  productName: {
    fontSize: 14,
    fontWeight: "bold",
    marginTop: 8,
  },
  productStore: {
    fontSize: 12,
    color: "#777",
  },
  productPrice: {
    fontSize: 14,
    fontWeight: "bold",
    color: "#6C63FF",
    marginTop: 4,
  },
  navbarContainer: {
    position: "absolute",
    left: 10,
    right: 10,
    bottom: 5,
    height: 70,
    paddingBottom: 10,
    overflow: "hidden",
    borderRadius: 50,
  },
  navbarBg: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
    width: "100%",
    height: "120%",

  },
  navIcon: {
    width: 28,
    height: 28,
  },

});