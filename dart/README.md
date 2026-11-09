# Number Base Converter API - Dart/Flutter Client

Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal. Pass a value with optional source and target bases to receive the converted string, base names, and exact decimal values.

[![pub package](https://img.shields.io/pub/v/apiverve_numberbaseconverter.svg)](https://pub.dev/packages/apiverve_numberbaseconverter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Number Base Converter API](https://apiverve.com/marketplace/numberbaseconverter?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_numberbaseconverter: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_numberbaseconverter/apiverve_numberbaseconverter.dart';

void main() async {
  final client = NumberbaseconverterClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'value': '255',
      'from': 10,
      'to': 10
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "input_value": "FF",
    "input_base": 16,
    "input_base_name": "hexadecimal",
    "decimal_value": 255,
    "decimal_value_exact": "255",
    "output_value": "255",
    "output_base": 10,
    "output_base_name": "decimal"
  }
}
```

## API Reference

- **API Home:** [Number Base Converter API](https://apiverve.com/marketplace/numberbaseconverter?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/numberbaseconverter](https://docs.apiverve.com/ref/numberbaseconverter?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
