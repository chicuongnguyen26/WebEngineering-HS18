import mvc.UserPasswordEncoderListener
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    passwordEncoder(PlaintextPasswordEncoder)
}
