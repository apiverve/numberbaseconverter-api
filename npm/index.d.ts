declare module '@apiverve/numberbaseconverter' {
  export interface numberbaseconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface numberbaseconverterResponse {
    status: string;
    error: string | null;
    data: NumberBaseConverterData;
    code?: number;
  }


  interface NumberBaseConverterData {
      inputValue:     string;
      inputBase:      number;
      inputBaseName:  string;
      decimalValue:   number;
      outputValue:    string;
      outputBase:     number;
      outputBaseName: string;
  }

  export default class numberbaseconverterWrapper {
    constructor(options: numberbaseconverterOptions);

    execute(callback: (error: any, data: numberbaseconverterResponse | null) => void): Promise<numberbaseconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: numberbaseconverterResponse | null) => void): Promise<numberbaseconverterResponse>;
    execute(query?: Record<string, any>): Promise<numberbaseconverterResponse>;
  }
}
