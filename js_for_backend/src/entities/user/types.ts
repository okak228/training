export interface User {
  id: string;
  name: string;
  role: string;
}

export interface UserRole {
  name: string;
  role: string;
}

export interface CurrentUser {
  name: string;
  role: string;
  accessToken: string;
}

export interface AuthState {
  user: CurrentUser | null;
  setCurrentUser: (user: CurrentUser | null) => void;
}
