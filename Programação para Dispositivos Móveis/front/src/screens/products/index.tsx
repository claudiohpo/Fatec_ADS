import { View, Text, Image, ListRenderItemInfo, ScrollView, ImageBackground, Alert, TouchableOpacity } from "react-native";
import { styles } from "./styles";
import sacola from "../../../assets/Sacola.png";
import { useNavigation } from "@react-navigation/native";
import macbook_air from "../../../assets/macbook_air.png";
import macbook_pro from "../../../assets/macbook_pro.png";
import banner from "../../../assets/banner.png";
import pcGamerEasyPC from "../../../assets/pc_gamer_easy.png";
import pcGamerRocket from "../../../assets/pc_gamer_rocket.png";
import pcGamerGT from "../../../assets/pc_gamer_gt.png";
import corei7 from "../../../assets/corei7.png";
import ryzen7 from "../../../assets/ryzen7.png";
import ryzen5 from "../../../assets/ryzen5.png";
import headset from "../../../assets/headsetHyperX.png";
import mouse from "../../../assets/mouseRedDragon.png";
import webcam from "../../../assets/webcamRedDragon.png";
import home from "../../../assets/Vector.png";
import group from "../../../assets/Group.png";
import blocks from "../../../assets/blocks2.png";
import MiniPhoto from "../../../assets/Profile_photo.png";
import gradientBg from "../../../assets/backgroundHorizontal.png";

interface Produto {
  id: string;
  nome: string;
  preco: string;
  loja: string;
  imagem: any;
}

export function Products() {
  const navigation = useNavigation();
  const produtos = [
    { id: "1", categoria: "Notebooks", nome: "MacBook Air", preco: "R$ 7.999,99", loja: "Loja Sistech Eletronicos", imagem: macbook_air },
    { id: "2", categoria: "Notebooks", nome: "MacBook Pro", preco: "R$ 11.999,99", loja: "Loja Eletrosystem", imagem: macbook_pro },
    { id: "3", categoria: "Notebooks", nome: "MacBook Air", preco: "R$ 7.999,99", loja: "Loja Eletrosystem", imagem: macbook_air },
    { id: "4", categoria: "Computadores", nome: "PCGamer EasyPC", preco: "R$ 3.599,99", loja: "Loja Sistech Eletronicos", imagem: pcGamerEasyPC },
    { id: "5", categoria: "Computadores", nome: "PCGamer Rocket", preco: "R$ 2.589,99", loja: "Loja Eletrosystem", imagem: pcGamerRocket },
    { id: "6", categoria: "Computadores", nome: "PCGamer GT", preco: "R$ 3.999,99", loja: "Loja Eletrosystem", imagem: pcGamerGT },
    { id: "7", categoria: "Processadores", nome: "Core i7", preco: "R$ 2.299,99", loja: "Loja Sistech Eletronicos", imagem: corei7 },
    { id: "8", categoria: "Processadores", nome: "Ryzen 7", preco: "R$ 1.899,99", loja: "Loja Eletrosystem", imagem: ryzen7 },
    { id: "9", categoria: "Processadores", nome: "Ryzen 5", preco: "R$ 1.499,99", loja: "Loja Eletrosystem", imagem: ryzen5 },
    { id: "10", categoria: "Periféricos", nome: "Headset HyperX", preco: "R$ 299,99", loja: "Loja Sistech Eletronicos", imagem: headset },
    { id: "11", categoria: "Periféricos", nome: "Mouse Redragon", preco: "R$ 149,99", loja: "Loja Eletrosystem", imagem: mouse },
    { id: "12", categoria: "Periféricos", nome: "Webcam Redragon", preco: "R$ 199,99", loja: "Loja Eletrosystem", imagem: webcam }
  ];

 



  const renderItem = ({ item }: ListRenderItemInfo<Produto>) => (
    <View style={styles.productCard}>
      <Image source={item.imagem} style={styles.productImage} resizeMode="contain" />
      <Text style={styles.productName}>{item.nome}</Text>
      <Text style={styles.productStore}>{item.loja}</Text>
      <Text style={styles.productPrice}>{item.preco}</Text>
    </View>
  );

  const renderSection = (categoria: string) => {
    const itens = produtos.filter((p) => p.categoria === categoria);

    return (
      <View key={categoria} style={styles.content}>

        <ScrollView
          horizontal
          showsHorizontalScrollIndicator={false}
          contentContainerStyle={styles.productList}
        >
          {itens.map((item) => (
            <View key={item.id} style={styles.productCard}>
              <Image
                source={item.imagem}
                style={styles.productImage}
                resizeMode="contain"
              />
              <Text style={styles.productName}>{item.nome}</Text>
              <Text style={styles.productStore}>{item.loja}</Text>
              <Text style={styles.productPrice}>{item.preco}</Text>
            </View>
          ))}
        </ScrollView>
      </View>
    );
  };

  return (
    <View style={styles.container}>

      <View style={styles.containerTitle}>
        <Text style={styles.title}>Home {"\n"}</Text>
        <Image source={sacola} style={styles.imageLogo} resizeMode="stretch" />
      </View>

      <View style={styles.content2}>
        <ScrollView>


          <View style={styles.imageBanner}>
            <Image
              source={banner}
              style={styles.imageBanner}
              resizeMode="stretch"
            />
          </View>

          {/* Seção 1 - Notebooks */}
          <View style={styles.content}>
            <View style={styles.containerSubtitle}>
              <Text style={styles.subtitle}>Notebooks</Text>
              <Text style={styles.label}>Ver tudo</Text>
            </View>

            <ScrollView
              horizontal
              showsHorizontalScrollIndicator={false}
              contentContainerStyle={styles.productList}
            >
              {renderSection("Notebooks")}
            </ScrollView>
          </View>

          {/* Seção 2 - Computadores */}
          <View style={styles.content}>
            <View style={styles.containerSubtitle}>
              <Text style={styles.subtitle}>Computadores</Text>
              <Text style={styles.label}>Ver tudo</Text>
            </View>

            <ScrollView
              horizontal
              showsHorizontalScrollIndicator={false}
              contentContainerStyle={styles.productList}
            >
              {renderSection("Computadores")}
            </ScrollView>
          </View>

          {/* Seção 3 - Processadores */}
          <View style={styles.content}>
            <View style={styles.containerSubtitle}>
              <Text style={styles.subtitle}>Processadores</Text>
              <Text style={styles.label}>Ver tudo</Text>
            </View>

            <ScrollView
              horizontal
              showsHorizontalScrollIndicator={false}
              contentContainerStyle={styles.productList}
            >
              {renderSection("Processadores")}
            </ScrollView>
          </View>

          {/* Seção 3 - Periféricos */}
          <View style={styles.content}>
            <View style={styles.containerSubtitle}>
              <Text style={styles.subtitle}>Periféricos</Text>
              <Text style={styles.label}>Ver tudo</Text>
            </View>

            <ScrollView
              horizontal
              showsHorizontalScrollIndicator={false}
              contentContainerStyle={styles.productList}
            >
              {renderSection("Periféricos")}
            </ScrollView>
          </View>

        </ScrollView>
      </View>

      {/* Botões Rodapé */}
      <View style={styles.navbarContainer}>
        <ImageBackground
          source={gradientBg}
          resizeMode="stretch"
          style={styles.navbarBg}
        >
          <Image source={home} style={styles.navIcon} />
          <Image source={group} style={styles.navIcon} />
          <Image source={blocks} style={styles.navIcon} />
            <TouchableOpacity
            onPress={() =>
              Alert.alert(
                "Aviso",
                "Deseja efetuar logoff?",
                [
                  {
                    text: "Sim",
                    style: "default",
                    onPress: () => navigation.navigate("Home" as never),
                  },
                  {
                    text: "Não",
                    style: "cancel",
                  },
                ],
                { cancelable: true }
              )
            }
          >
            <Image source={MiniPhoto} style={styles.navIcon} />
            </TouchableOpacity>
        </ImageBackground>
      </View>


    </View>
  );
}
