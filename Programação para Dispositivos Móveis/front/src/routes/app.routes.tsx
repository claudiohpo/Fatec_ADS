import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { Start } from '../screens/start';
import { Home } from '../screens/home';
import { SignIn } from '../screens/signin';
import { Password } from '../screens/password';
import { Confirm } from '../screens/confirm';
import { CheckEmail } from '../screens/check_email';
// import { App4 } from '../screens/reset';

const Stack = createStackNavigator();

export function AppRoutes() {
  return(
    <Stack.Navigator screenOptions={{headerShown:false}} >
      <Stack.Screen name="Start" component={Start} />      
      <Stack.Screen name="Home" component={Home} />
      <Stack.Screen name="SignIn" component={SignIn} />
      <Stack.Screen name="Password" component={Password} />
      <Stack.Screen name="Confirm" component={Confirm} />
      <Stack.Screen name="CheckEmail" component={CheckEmail} />
      {/* <Stack.Screen name="Reset" component={App4} /> */}

    </Stack.Navigator>
  );
}