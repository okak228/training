import { Entity, EntityPageRs } from '../types';
import api from 'app/api/api';

type GetParams = {
  page: string;
  limit: string;
  name: string;
};

export const getEntities = async (params: GetParams) => {
  const search = new URLSearchParams(params).toString();
  const response = await api.get(`/entities?${search}`);
  const pageRs: EntityPageRs = await response.data;
  return pageRs;
};

export const getEntity = async (id: string) => {
  const response = await api.get(`/entities/${id}`);
  const entity: Entity = await response.data;
  return entity;
};

interface CreateParams {
  name: string;
  description: string;
  date: string;
  dateTime: Date;
  userId: Date;
}

export const createEntity = async (params: CreateParams) => {
  const response = await api.post(`/entities`, params);
  const entity: Entity = await response.data;
  return entity;
};

interface UpdateParams {
  id: string;
  name: string;
  description: string;
  date: string;
  dateTime: Date;
  userId: Date;
}

export const updateEntity = async (params: UpdateParams) => {
  const response = await api.put(`/entities/${params.id}`, params);
  const entity: Entity = await response.data;
  return entity;
};

export const deleteEntity = async (id: string) => {
  const response = await api.delete(`/entities/${id}`);
  const entity: Entity = await response.data;
  return entity;
};
