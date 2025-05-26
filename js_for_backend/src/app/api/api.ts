export const baseURL = 'http://localhost:8080';

import axios from 'axios';
import { useAuthStore } from 'entities/user';

// Создаем кастомный экземпляр axios
const api = axios.create({
  baseURL: baseURL, // Базовый URL
  headers: {
    'Content-Type': 'application/json',
  },
});

// Добавляем интерцептор для запросов
api.interceptors.request.use(
  (config) => {
    // Получаем токен из хранилища (localStorage, cookie, store и т.д.)
    const token = useAuthStore.getState().user.accessToken;

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

export default api;
