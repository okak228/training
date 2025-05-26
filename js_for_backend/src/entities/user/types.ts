export interface User {
  id: string;
  name: string;
  role: string;
}

export interface StorageUser {
  name: string;
  role: string;
  accessToken: string;
}

export interface AuthState {
  user: StorageUser | null;
  setStorageUser: (user: StorageUser | null) => void;
}
