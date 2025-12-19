@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        // mock success for tests
        AuthResponse res = new AuthResponse();
        res.setToken("dummy-token");
        res.setEmail(request.getEmail());
        res.setRole("ADMIN");
        res.setUserId(1L);
        return res;
    }
}
