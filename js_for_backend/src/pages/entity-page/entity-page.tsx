import {
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
  Typography,
} from '@mui/material';
import React, { useEffect, useState } from 'react';
import { Controller, useForm } from 'react-hook-form';
import { useNavigate, useParams } from 'react-router-dom';

import styles from './styles.module.css';
import { createEntity, getEntity, updateEntity } from 'entities/entity';
import { getUsers, User } from 'entities/user';
import {
  DatePicker,
  DateTimePicker,
  LocalizationProvider,
} from '@mui/x-date-pickers';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';

export const EntityPage = () => {
  const [users, setUsers] = useState<User[]>([]);

  const { id } = useParams();
  const isNew = id === 'new';

  const navigate = useNavigate();

  const fetchEntity = async () => {
    const entity = await getEntity(id);
    reset(entity);
  };

  const fetchUsers = async () => {
    const users = await getUsers();
    setUsers(users);
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  const {
    control,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  useEffect(() => {
    if (!isNew) {
      fetchEntity();
    } else {
      reset({ id: null });
    }
  }, [id]);

  const handleFormSubmit = async (values) => {
    if (isNew) {
      const entity = await createEntity(values);
      navigate(`/entity/${entity.id}`);
    } else {
      await updateEntity(values);
      navigate('/entity');
    }
  };

  return (
    <div className={styles.page}>
      <form className={styles.form} onSubmit={handleSubmit(handleFormSubmit)}>
        <Typography>{isNew ? 'Создание' : 'Редактирование'}</Typography>
        <Controller
          name="name"
          control={control}
          rules={{ validate: (v) => Boolean(v?.trim()) }}
          render={({ field: { value = '', onChange } }) => (
            <TextField
              label="Имя"
              value={value}
              onChange={onChange}
              error={Boolean(errors.name)}
            />
          )}
        />
        <Controller
          name="description"
          control={control}
          rules={{ validate: (v) => Boolean(v?.trim()) }}
          render={({ field: { value = '', onChange } }) => (
            <TextField
              label="Описание"
              value={value}
              onChange={onChange}
              error={Boolean(errors.description)}
            />
          )}
        />
        <Controller
          name="date"
          control={control}
          render={({ field: { value = '', onChange } }) => (
            <LocalizationProvider dateAdapter={AdapterDateFns}>
              <DatePicker
                label="Дата"
                value={new Date(value)}
                onChange={onChange}
                slotProps={{ textField: { error: Boolean(errors.date) } }}
              />
            </LocalizationProvider>
          )}
        />
        <Controller
          name="dateTime"
          control={control}
          render={({ field: { value = '', onChange } }) => (
            <LocalizationProvider dateAdapter={AdapterDateFns}>
              <DateTimePicker
                label="Дата с временем"
                value={new Date(value)}
                onChange={onChange}
                ampm={false}
                slotProps={{ textField: { error: Boolean(errors.dateTime) } }}
              />
            </LocalizationProvider>
          )}
        />
        <Controller
          name="userId"
          control={control}
          rules={{ validate: (v) => Boolean(v?.trim()) }}
          render={({ field: { value = '', onChange } }) => (
            <FormControl>
              <InputLabel>Тип</InputLabel>
              <Select
                label="Тип"
                value={value}
                onChange={onChange}
                error={Boolean(errors.login)}
              >
                {users.map((user) => (
                  <MenuItem value={user.id} key={user.id}>
                    {user.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
          )}
        />
        <Button variant="contained" type="submit">
          {isNew ? 'Создать' : 'Сохранить'}
        </Button>
      </form>
    </div>
  );
};
