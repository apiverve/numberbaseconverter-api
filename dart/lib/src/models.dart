/// Response models for the Number Base Converter API.

/// API Response wrapper.
class NumberbaseconverterResponse {
  final String status;
  final dynamic error;
  final NumberbaseconverterData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  NumberbaseconverterResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory NumberbaseconverterResponse.fromJson(Map<String, dynamic> json) => NumberbaseconverterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? NumberbaseconverterData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Number Base Converter API.

class NumberbaseconverterData {
  String? inputValue;
  num? inputBase;
  String? inputBaseName;
  num? decimalValue;
  String? decimalValueExact;
  String? outputValue;
  num? outputBase;
  String? outputBaseName;

  NumberbaseconverterData({
    this.inputValue,
    this.inputBase,
    this.inputBaseName,
    this.decimalValue,
    this.decimalValueExact,
    this.outputValue,
    this.outputBase,
    this.outputBaseName,
  });

  factory NumberbaseconverterData.fromJson(Map<String, dynamic> json) => NumberbaseconverterData(
      inputValue: json['input_value'],
      inputBase: json['input_base'],
      inputBaseName: json['input_base_name'],
      decimalValue: json['decimal_value'],
      decimalValueExact: json['decimal_value_exact'],
      outputValue: json['output_value'],
      outputBase: json['output_base'],
      outputBaseName: json['output_base_name'],
    );
}

class NumberbaseconverterRequest {
  String value;
  int? from;
  int? to;

  NumberbaseconverterRequest({
    required this.value,
    this.from,
    this.to,
  });

  Map<String, dynamic> toJson() => {
      'value': value,
      if (from != null) 'from': from,
      if (to != null) 'to': to,
    };
}
