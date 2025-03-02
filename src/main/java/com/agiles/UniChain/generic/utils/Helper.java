package com.agiles.UniChain.generic.utils;

import com.agiles.UniChain.auth.CustomUserDetails;
import com.agiles.UniChain.auth.model.Role;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;

@Component
public class Helper {

    @Autowired
    private RoleRepo roleRepository;

    public static User getCurrentUser() {
        User user = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  // Get current authentication

        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();  // Get the authenticated user details

            user.setId(userDetails.getId());  // Set the ID
            user.setUsername(userDetails.getUsername());  // Set the username
            user.setEmail(userDetails.getEmail());  // Set the email
            user.setPassword(userDetails.getPassword());  // Set the password (optional)
            user.setRoles(userDetails.getRoles());  // Set the roles (assuming getRoles() returns Set<Role>)

            return user;
        }

        return null;
    }

    public static void throwCaseSpecificDuplicateValidationMessage(String fieldName, boolean isActive) {
        throw new RuntimeException(isActive ? fieldName + " is already exist" : fieldName + " is already exist in archive");
    }

    public static String getPartsNoSuffixForPartsNameResponse(String partsNo) {
        return Objects.nonNull(partsNo) && !partsNo.isEmpty() ? " (" + partsNo + ")" : "";
    }

    public static String createDynamicCode(String errorCode, String... placeHolders) {
        StringBuilder builder = new StringBuilder(errorCode);
        if (Objects.isNull(placeHolders)) {
            return errorCode;
        }
        Arrays.stream(placeHolders).forEach(placeHolder ->
                builder.append(" | ").append(placeHolder));
        return builder.toString();
    }

    public static String generateSixDigitOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(900000) + 100000;
        return Integer.toString(number);
    }

    public static String generateAlphaNumericCode(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57) || (i >= 65 && i <= 90))  // Restrict to alphanumeric characters
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String encodeUrl(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decodeUrl(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static double formatDoubleValue(Double value) {
        double checkedValue = (value != null) ? value : 0.0;
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(checkedValue));
    }


    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType.equals("application/vnd.ms-excel") || contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static String spaceRemoveAndLowerCase(String text) {
        return text.replace(" ", "").toLowerCase();
    }

    public static String encodeToString(String generatedId) {
        return Base64.getEncoder().encodeToString(generatedId.getBytes());
    }

    public static String decodeToString(String generatedId) {
        return new String(Base64.getDecoder().decode(generatedId));
    }

//    public Role getRoleByRoleType(String roleType) {
//        return roleRepository.findByRoleType(roleType)
//                .orElseThrow(() -> new RuntimeException("Role not found with type: " + roleType));
//    }
}
