import { CurrentUser, User, UserRole } from '../types';
import api from 'app/api/api';

interface UserParams {
  name: string;
  password: string;
}

interface MessageResponse {
  text: string;
}

export const getUsers = async () => {
  const response = await api.get('/user/all');
  const users: User[] = await response.data;
  return users;
};

export const getUser = async () => {
  const response = await api.get('/user/current');
  const userRole: UserRole = await response.data;
  return userRole ?? null;
};

export const createUser = async (params: UserParams) => {
  const response = await api.post('/auth/sign-up', {
    params,
  });
  const user: MessageResponse = await response.data;
  return user;
};

export const signIn = async (params: UserParams) => {
  const response = await api.post('/auth/sign-in', {
    params,
  });
  const user: CurrentUser = await response.data;
  return user;
};
