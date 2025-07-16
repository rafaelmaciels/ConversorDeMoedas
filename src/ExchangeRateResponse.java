import java.util.Map;

// Usamos 'record' para uma classe de dados imutável e concisa.
// Os nomes das variáveis DEvem corresponder exatamente aos nomes das chaves no JSON.
public record ExchangeRateResponse(String result,
                                   String base_code,
                                   Map<String, Double> conversion_rates) {
}
