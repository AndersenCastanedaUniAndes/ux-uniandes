import React, { useState } from 'react';
import {
    Box,
    Button,
    Checkbox,
    Container,
    Dialog,
    DialogContent,
    Divider,
    Grid,
    Link,
    TextField,
    Typography,
    FormControlLabel
} from '@mui/material';

import { useNavigate } from 'react-router-dom';

import icon from '../assets/icon.png';
import googleIcon from '../assets/google-icon.png';
import illustration from '../assets/illustration.png';

function LoginPage() {
    // Control de modales
    const [openEmailModal, setOpenEmailModal] = useState(false);
    const [openPasswordModal, setOpenPasswordModal] = useState(false);

    // Campos de formulario
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);

    const navigate = useNavigate();

    // Abre la modal de correo al pulsar el botón “Continuar con Google”
    const handleLoginWithGoogle = () => {
        setOpenEmailModal(true);
    };

    // Cierra la modal de correo
    const handleCloseEmailModal = () => {
        setOpenEmailModal(false);
    };

    // Cierra la modal de contraseña
    const handleClosePasswordModal = () => {
        setOpenPasswordModal(false);
    };

    // Pasa de la modal de correo a la de contraseña
    const handleOpenPasswordModal = () => {
        setOpenEmailModal(false);
        setOpenPasswordModal(true);
    };

    // Al pulsar “Siguiente” en la modal de contraseña
    const handleSubmitPassword = () => {
        console.log('Iniciar sesión con:', { email, password });
        setOpenPasswordModal(false);
        // Aquí podrías navegar a otra página o guardar token, etc.
        navigate('/app');
    };

    return (
        <Container maxWidth="lg" sx={{ height: '100vh' }}>
            <Grid container sx={{ height: '100%' }}>
                {/* Columna Izquierda */}
                <Grid
                    item
                    xs={12}
                    md={6}
                    display="flex"
                    flexDirection="column"
                    justifyContent="center"
                    alignItems="flex-start"
                    p={4}
                >
                    {/* Título */}
                    <Box display="flex" alignItems="center" mb={2}>
                <Box
                  component="img"
                  src={icon}
                  alt="StepOut Logo"
                  sx={{ width: 48, height: 48, mr: 2 }}
                />
                        <Typography variant="h3" color="primary" fontWeight="bold">
                            StepOut
                        </Typography>
                    </Box>

                    {/* Descripción */}
                    <Typography variant="body1" color="text.primary" mb={4}>
                        Descubre el secreto para disfrutar de una rutina de estudio o trabajo
                    </Typography>

                    {/* Botón "Continuar con Google" */}
                    <Button
                        variant="filledTonal" // Antes: "contained"
                        onClick={handleLoginWithGoogle}
                        sx={{
                            backgroundColor: '#E8DEF8', // Ajusta a tu theme si es necesario
                            color: '#4A4459', // Texto con buen contraste
                            textTransform: 'none', // Para mantener el texto en formato normal
                            borderRadius: 2,
                            paddingX: 3,
                            paddingY: 1.2
                        }}
                        startIcon={
                            <Box
                                component="img"
                                src={googleIcon}
                                alt="Google Logo"
                                sx={{ width: 20, height: 20 }}
                            />
                        }
                    >
                        Continuar con Google
                    </Button>
                </Grid>

                {/* Columna Derecha (Ilustración) */}
                <Grid
                    item
                    xs={12}
                    md={6}
                    sx={{
                        backgroundColor: 'background.default',
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',
                        p: 2
                    }}
                >
                    <Box
                        component="img"
                        src={illustration}
                        alt="Ilustración de Login"
                        sx={{
                            maxWidth: '100%',
                            height: 'auto',
                            objectFit: 'contain'
                        }}
                    />
                </Grid>
            </Grid>

            {/* MODAL: Correo */}
            <Dialog
                open={openEmailModal}
                onClose={handleCloseEmailModal}
                fullWidth
                maxWidth="xs"
            >
                <DialogContent sx={{ p: 3 }}>
                    {/* Encabezado */}
                    <Typography variant="subtitle1" fontWeight="bold">
                        Acceder con Google
                    </Typography>
                    <Typography variant="body2" color="primary" sx={{ mt: 0.5 }}>
                        Ir a StepOut
                    </Typography>

                    <Box mt={2} />

                    {/* Campo de correo */}
                    <TextField
                        fullWidth
                        label="Correo electrónico o teléfono"
                        variant="outlined"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        margin="dense"
                    />

                    {/* ¿Olvidaste el correo electrónico? */}
                    <Typography variant="body2" color="primary" sx={{ mt: 1, cursor: 'pointer' }}>
                        ¿Olvidaste el correo electrónico?
                    </Typography>

                    <Box mt={2} />

                    {/* Disclaimer */}
                    <Typography variant="body2" color="text.secondary">
                        Antes de usar StepOut, revisa su política de privacidad y condiciones del servicio.
                    </Typography>

                    <Box mt={2} />

                    {/* Footer: Crear cuenta | Siguiente */}
                    <Box display="flex" justifyContent="space-between" alignItems="center">
                        <Typography
                            variant="body2"
                            color="primary"
                            sx={{ cursor: 'pointer' }}
                        >
                            Crear cuenta
                        </Typography>
                        <Button variant="contained" onClick={handleOpenPasswordModal}>
                            Siguiente
                        </Button>
                    </Box>

                    <Box mt={2} />

                    <Divider />

                    <Box mt={2} display="flex" justifyContent="space-evenly">
                        <Typography
                            variant="body2"
                            color="primary"
                            sx={{ cursor: 'pointer' }}
                        >
                            Español (Latinoamérica)
                        </Typography>
                        <Typography
                            variant="body2"
                            color="primary"
                            sx={{ cursor: 'pointer' }}
                        >
                            Ayuda
                        </Typography>
                        <Typography
                            variant="body2"
                            color="primary"
                            sx={{ cursor: 'pointer' }}
                        >
                            Privacidad
                        </Typography>
                        <Typography
                            variant="body2"
                            color="primary"
                            sx={{ cursor: 'pointer' }}
                        >
                            Condiciones
                        </Typography>
                    </Box>
                </DialogContent>
            </Dialog>

            {/* MODAL: Contraseña */}
            <Dialog
                open={openPasswordModal}
                onClose={handleClosePasswordModal}
                fullWidth
                maxWidth="xs"
            >
                <DialogContent sx={{ p: 3 }}>
                    {/* Encabezado */}
                    <Typography variant="subtitle1" fontWeight="bold">
                        Te damos la bienvenida
                    </Typography>
                    <Typography variant="body2" color="primary" sx={{ mt: 0.5 }}>
                        {email || 'tu_correo@example.com'}
                    </Typography>

                    <Box mt={2} />

                    {/* Campo de contraseña */}
                    <TextField
                        fullWidth
                        label="Ingresa tu contraseña"
                        type={showPassword ? 'text' : 'password'}
                        variant="outlined"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        margin="dense"
                    />

                    {/* Checkbox mostrar contraseña */}
                    <FormControlLabel
                        control={
                            <Checkbox
                                checked={showPassword}
                                onChange={() => setShowPassword(!showPassword)}
                            />
                        }
                        label="Mostrar contraseña"
                    />

                    {/* ¿Olvidaste la contraseña? */}
                    <Typography variant="body2" color="primary" sx={{ mt: 1, cursor: 'pointer' }}>
                        ¿Olvidaste la contraseña?
                    </Typography>

                    <Box mt={2} />

                    {/* Disclaimer */}
                    <Typography variant="body2" color="text.secondary">
                        Antes de usar StepOut, revisa su política de privacidad y condiciones del servicio.
                    </Typography>

                    <Box mt={2} />

                    {/* Footer: Siguiente */}
                    <Box display="flex" justifyContent="flex-end">
                        <Button variant="contained" onClick={handleSubmitPassword}>
                            Iniciar sesión
                        </Button>
                    </Box>

                    <Box mt={2} />

                    <Divider />

                    <Box mt={2} display="flex" justifyContent="space-evenly">
                        <Typography variant="body2" color="primary" sx={{ cursor: 'pointer' }}>
                            Español (Latinoamérica)
                        </Typography>
                        <Typography variant="body2" color="primary" sx={{ cursor: 'pointer' }}>
                            Ayuda
                        </Typography>
                        <Typography variant="body2" color="primary" sx={{ cursor: 'pointer' }}>
                            Privacidad
                        </Typography>
                        <Typography variant="body2" color="primary" sx={{ cursor: 'pointer' }}>
                            Condiciones
                        </Typography>
                    </Box>
                </DialogContent>
            </Dialog>
        </Container>
    );
}

export default LoginPage;
