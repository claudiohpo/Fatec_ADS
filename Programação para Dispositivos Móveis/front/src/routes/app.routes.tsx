import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { Start } from '../screens/start';
import { Home } from '../screens/home';
import { SignIn } from '../screens/signin';
import { Password } from '../screens/forget_password';
import { Address2 } from '../screens/address2';
import { CheckEmail } from '../screens/check_email';
import { Address } from '../screens/address';
import { PersonalData } from '../screens/personanal_data';

const Stack = createStackNavigator();

export function AppRoutes() {
  return(
    <Stack.Navigator screenOptions={{headerShown:false}} >
      <Stack.Screen name="Start" component={Start} />      
      <Stack.Screen name="Home" component={Home} />
      <Stack.Screen name="SignIn" component={SignIn} />
      <Stack.Screen name="Password" component={Password} />
      <Stack.Screen name="Address2" component={Address2} />
      <Stack.Screen name="CheckEmail" component={CheckEmail} />
      <Stack.Screen name="Address" component={Address} />
      <Stack.Screen name="PersonalData" component={PersonalData} />

    </Stack.Navigator>
  );
}