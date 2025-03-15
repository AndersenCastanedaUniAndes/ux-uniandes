import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import App from './App.jsx';
import theme from './Theme.js';
import { ThemeProvider } from '@emotion/react';
import Login from './pages/Login.jsx';
import { HashRouter, Routes, Route, Navigate } from 'react-router-dom';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ThemeProvider theme={theme}>
      <LocalizationProvider dateAdapter={AdapterDateFns}>
        <HashRouter>
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/app" element={<App />} />
            <Route path="/" element={<Navigate to="/login" replace />} />
          </Routes>
        </HashRouter>
      </LocalizationProvider>
    </ThemeProvider>
  </StrictMode>
);